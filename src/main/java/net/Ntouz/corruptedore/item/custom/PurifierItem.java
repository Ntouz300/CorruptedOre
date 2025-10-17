package net.Ntouz.corruptedore.item.custom;

import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.component.ModDataComponentTypes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Map;

public class PurifierItem extends Item {
    private static final Map<Block, Block> PURIFIER_MAP =
            Map.of(
                    ModBlocks.CORRUPTED_BLOCK.get(), ModBlocks.PURE_BLOCK.get(),
                    ModBlocks.CORRUPTED_ORE.get(), ModBlocks.PURE_ORE.get(),
                    ModBlocks.RICH_CORRUPTED_ORE.get(), ModBlocks.RICH_PURE_ORE.get()
            );


    public PurifierItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if(PURIFIER_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), PURIFIER_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.corruptedore.purifier_item.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.corruptedore.purifier_item"));

        }

        if(pStack.get(ModDataComponentTypes.COORDINATES.get()) != null) {
            pTooltipComponents.add(Component.literal("Last Block purified at " + pStack.get(ModDataComponentTypes.COORDINATES.get())));

        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
