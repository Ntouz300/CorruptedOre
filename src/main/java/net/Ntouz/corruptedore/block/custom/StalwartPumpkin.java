package net.Ntouz.corruptedore.block.custom;

import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.component.ModDataComponentTypes;
import net.Ntouz.corruptedore.entity.ModEntities;
import net.Ntouz.corruptedore.entity.custom.SmallStalwartGolemEntity;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;


public class StalwartPumpkin extends PumpkinBlock {
    public StalwartPumpkin(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack itemStack, BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hit
    ) {
        if (!itemStack.canPerformAction(net.minecraftforge.common.ToolActions.SHEARS_CARVE)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (level.isClientSide) {
            return ItemInteractionResult.sidedSuccess(true);
        }

        Direction facing = hit.getDirection().getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : hit.getDirection();
        BlockPos support = blockPos.below();
        BlockState supportState = level.getBlockState(support);

        if (supportState.is(ModBlocks.PURE_BLOCK.get())) {
            // Remove pumpkin and support block to spawn golem
            level.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 3);
            level.setBlock(support, Blocks.AIR.defaultBlockState(), 3);

            // Spawn the golem
            SmallStalwartGolemEntity golem = ModEntities.SMALL_STALWART_GOLEM.get().create(level);
            if (golem != null) {
                // Face the golem toward the player
                float yaw = player.getYRot();
                golem.moveTo(support.getX() + 0.5, support.getY(), support.getZ() + 0.5, yaw, 0);
                level.addFreshEntity(golem);
            }

            // Play sound & game event
            level.playSound(null, support, SoundEvents.IRON_GOLEM_STEP, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.gameEvent(null, GameEvent.ENTITY_PLACE, support);

            // Drop seeds
            ItemEntity seeds = new ItemEntity(
                    level,
                    blockPos.getX() + 0.5 + facing.getStepX() * 0.65,
                    blockPos.getY() + 0.1,
                    blockPos.getZ() + 0.5 + facing.getStepZ() * 0.65,
                    new ItemStack(Items.PUMPKIN_SEEDS, 4)
            );
            seeds.setDeltaMovement(
                    0.05 * facing.getStepX() + level.random.nextDouble() * 0.02,
                    0.05,
                    0.05 * facing.getStepZ() + level.random.nextDouble() * 0.02
            );
            level.addFreshEntity(seeds);

            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            level.gameEvent(player, GameEvent.SHEAR, blockPos);
            player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
        } else {
            // Carve the pumpkin normally (it stays in place)
            level.setBlock(blockPos, ModBlocks.SALWART_GOLEM_HEAD.get().defaultBlockState().setValue(StalwartGolemHead.FACING, facing), 3);
            level.playSound(null, blockPos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);

            // Drop seeds
            ItemEntity seeds = new ItemEntity(
                    level,
                    blockPos.getX() + 0.5 + facing.getStepX() * 0.65,
                    blockPos.getY() + 0.1,
                    blockPos.getZ() + 0.5 + facing.getStepZ() * 0.65,
                    new ItemStack(Items.PUMPKIN_SEEDS, 4)
            );
            seeds.setDeltaMovement(
                    0.05 * facing.getStepX() + level.random.nextDouble() * 0.02,
                    0.05,
                    0.05 * facing.getStepZ() + level.random.nextDouble() * 0.02
            );
            level.addFreshEntity(seeds);

            itemStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
            level.gameEvent(player, GameEvent.SHEAR, blockPos);
            player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.corruptedore.stalwart_pumpkin.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.corruptedore.stalwart_pumpkin"));

        }

        if(pStack.get(ModDataComponentTypes.COORDINATES.get()) != null) {
            pTooltipComponents.add(Component.literal("Last Block purified at " + pStack.get(ModDataComponentTypes.COORDINATES.get())));

        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}


