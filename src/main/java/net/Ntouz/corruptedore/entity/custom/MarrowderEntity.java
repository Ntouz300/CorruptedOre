package net.Ntouz.corruptedore.entity.custom;

import net.Ntouz.corruptedore.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class MarrowderEntity extends Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();

    private int idleDelay = 0;

    public MarrowderEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    // --- GOALS ---
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.3D, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 20.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    // --- ATTRIBUTES ---
    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 18D)
                .add(Attributes.MOVEMENT_SPEED, 0.27D)
                .add(Attributes.FOLLOW_RANGE, 24.0D)
                .add(Attributes.ATTACK_DAMAGE, 3.0D);
    }

    // --- ANIMATIONS ---
    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide) {
            boolean isMoving = this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
            boolean isAttacking = this.attackAnimationState.isStarted();

            if (!isMoving && !isAttacking) {
                if (idleDelay <= 0) this.idleAnimationState.startIfStopped(this.tickCount);
                idleDelay = 10;
            } else {
                idleDelay = Math.max(idleDelay - 1, 0);
                this.idleAnimationState.stop();
            }
        }
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 4) {
            this.attackAnimationState.start(this.tickCount);
        } else {
            super.handleEntityEvent(id);
        }
    }

    // --- SOUNDS ---
    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.SKELETON_STEP, 1.0F, 1.0F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.SKELETON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    // --- ATTACK ---
    @Override
    public boolean doHurtTarget(Entity target) {
        this.level().broadcastEntityEvent(this, (byte) 4); // trigger animation
        boolean flag = target.hurt(this.damageSources().mobAttack(this), 12.0F);
        if (flag) {
            Vec3 motion = target.getDeltaMovement().add(0.0D, 0.4D, 0.0D);
            target.setDeltaMovement(motion);
        }
        this.playSound(SoundEvents.PLAYER_ATTACK_STRONG, 1.0F, 0.8F);
        return flag;
    }

    // --- SPAWN CONDITIONS ---
    public static boolean canSpawn(EntityType<? extends Mob> type, LevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return level.getBrightness(LightLayer.BLOCK, pos) < 8
                && level.getBlockState(pos.below()).is(BlockTags.BASE_STONE_OVERWORLD);
    }
}


