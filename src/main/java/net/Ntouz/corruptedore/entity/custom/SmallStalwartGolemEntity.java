package net.Ntouz.corruptedore.entity.custom;

import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;

public class SmallStalwartGolemEntity extends PathfinderMob {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState attackAnimationState = new AnimationState();

    public SmallStalwartGolemEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.3D, true));
        this.goalSelector.addGoal(2, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.3D, stack -> stack.is(ModItems.PURE_INGOT.get()), false));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 20.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Monster.class, true));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 60D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.ATTACK_DAMAGE, 8D);
    }
    private int idleDelay = 0;

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide) {
            boolean isMoving = this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D;
            boolean isAttacking = this.attackAnimationState.isStarted();

            if (!isMoving && !isAttacking) {
                if (idleDelay <= 0) this.idleAnimationState.startIfStopped(this.tickCount);
                idleDelay = 10; // small buffer to prevent flicker
            } else {
                idleDelay = Math.max(idleDelay - 1, 0);
                this.idleAnimationState.stop();
            }
        }
    }
    @Override
    public void handleEntityEvent(byte id) {
        if (id == 4) { // The attack byte we broadcasted
            this.attackAnimationState.start(this.tickCount);
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.IRON_GOLEM_STEP, 1.0F, 1.0F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return SoundEvents.IRON_GOLEM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.IRON_GOLEM_DEATH;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean doHurtTarget(Entity target) {
        this.level().broadcastEntityEvent(this, (byte)4); // triggers animation client-side
        boolean flag = target.hurt(this.damageSources().mobAttack(this), 12.0F);
        if (flag) {
            target.setDeltaMovement(target.getDeltaMovement().add(0.0D, 0.4D, 0.0D));
        }
        this.playSound(SoundEvents.IRON_GOLEM_ATTACK, 1.4F, 1.4F);
        return flag;
    }

    public static boolean canSpawnHere(EntityType<SmallStalwartGolemEntity> type, LevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
        return level.getBlockState(pos.below()).isSolid();
    }
    private static BlockPattern GOLEM_PATTERN;

    public static BlockPattern getGolemPattern() {
        if (GOLEM_PATTERN == null) {
            GOLEM_PATTERN = BlockPatternBuilder.start()
                    .aisle("^", "#")
                    .where('^', BlockInWorld.hasState(block -> block.getBlock() == ModBlocks.SALWART_GOLEM_HEAD.get()))
                    .where('#', BlockInWorld.hasState(block -> block.getBlock() == ModBlocks.PURE_BLOCK.get()))
                    .build();
        }
        return GOLEM_PATTERN;
    }
}


