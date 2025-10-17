package net.Ntouz.corruptedore.item.custom;

import net.Ntouz.corruptedore.component.ModDataComponentTypes;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class StalwartPaxelItem extends PaxelItem{
    public StalwartPaxelItem(Tier tier, float attackDamage, float attackSpeed, Properties pProperties) {
        super(tier, attackDamage, attackSpeed, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.corruptedore.stalwart_paxel_item.shift_down"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.corruptedore.stalwart_paxel_item"));

        }

        if(pStack.get(ModDataComponentTypes.COORDINATES.get()) != null) {
            pTooltipComponents.add(Component.literal("Last Block purified at " + pStack.get(ModDataComponentTypes.COORDINATES.get())));

        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
