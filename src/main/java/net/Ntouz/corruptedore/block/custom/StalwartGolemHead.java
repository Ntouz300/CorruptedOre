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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.gameevent.GameEvent;

import javax.annotation.Nullable;
import java.util.List;

public class StalwartGolemHead extends CarvedPumpkinBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public StalwartGolemHead(Properties properties) {
        super(properties);
            this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!level.isClientSide) {
            trySpawnGolem(level, pos);
        }
        super.onPlace(state, level, pos, oldState, isMoving);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    private void trySpawnGolem(Level level, BlockPos headPos) {
        // The single block below the head
        BlockPos support = headPos.below();

        BlockState supportState = level.getBlockState(support);

        // Check if it's the block that can support the golem (e.g., iron block)
        if (!supportState.is(ModBlocks.PURE_BLOCK.get())) {
            return; // pattern does not match
        }

        // Remove the head and support block
        level.setBlock(headPos, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState(), 3);
        level.setBlock(support, net.minecraft.world.level.block.Blocks.AIR.defaultBlockState(), 3);

        // Spawn your golem at the support block
        SmallStalwartGolemEntity golem = ModEntities.SMALL_STALWART_GOLEM.get().create(level);
        if (golem != null) {
            golem.moveTo(support.getX() + 0.5, support.getY(), support.getZ() + 0.5, 0, 0);
            level.addFreshEntity(golem);
        }

        // Play sound & particles
        level.playSound(null, support, SoundEvents.IRON_GOLEM_STEP, SoundSource.BLOCKS, 1.0f, 1.0f);
        level.gameEvent(null, GameEvent.ENTITY_PLACE, support);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.corruptedore.stalwart_golem_head.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.corruptedore.stalwart_golem_head"));

        }

        if(pStack.get(ModDataComponentTypes.COORDINATES.get()) != null) {
            pTooltipComponents.add(Component.literal("Last Block purified at " + pStack.get(ModDataComponentTypes.COORDINATES.get())));

        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
