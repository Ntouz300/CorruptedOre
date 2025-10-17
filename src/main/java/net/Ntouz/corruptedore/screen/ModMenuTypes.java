package net.Ntouz.corruptedore.screen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.screen.custom.PurifyingCauldronMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, CorruptedOre.MOD_ID);

    public static final RegistryObject<MenuType<PurifyingCauldronMenu>> PURIFYING_CAULDRON_MENU =
            MENUS.register("purifying_cauldron_menu", () -> IForgeMenuType.create(PurifyingCauldronMenu::new));



    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
