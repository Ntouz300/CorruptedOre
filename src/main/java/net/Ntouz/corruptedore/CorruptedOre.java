package net.Ntouz.corruptedore;

import com.mojang.logging.LogUtils;
import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.component.ModDataComponentTypes;
import net.Ntouz.corruptedore.entity.ModEntities;
import net.Ntouz.corruptedore.entity.client.CorruptedGnomeRenderer;
import net.Ntouz.corruptedore.entity.client.SmallStalwartGolemRenderer;
import net.Ntouz.corruptedore.util.ModCreativeModetabs;
import net.Ntouz.corruptedore.item.ModItems;
import net.Ntouz.corruptedore.util.ModItemProperties;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CorruptedOre.MOD_ID)
public class CorruptedOre {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "corruptedore";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public CorruptedOre() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        ModCreativeModetabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDataComponentTypes.register(modEventBus);

        ModEntities.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CORRUPTEDGEM);
            event.accept(ModItems.PUREGEM);
            event.accept(ModItems.CORRUPTEDFRAGMENT);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.CORRUPTED_BLOCK);
            event.accept(ModBlocks.PURE_BLOCK);
            event.accept(ModBlocks.RICH_CORRUPTED_ORE);
            event.accept(ModBlocks.RICH_PURE_ORE);
            event.accept(ModBlocks.PURE_ORE);
            event.accept(ModBlocks.CORRUPTED_ORE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();

            EntityRenderers.register(ModEntities.CORRUPTED_GNOME.get(), CorruptedGnomeRenderer::new);
            EntityRenderers.register(ModEntities.SMALL_STALWART_GOLEM.get(), SmallStalwartGolemRenderer::new);
        }

    }
}
