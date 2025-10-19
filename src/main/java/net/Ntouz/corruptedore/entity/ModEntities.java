package net.Ntouz.corruptedore.entity;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.custom.CorruptedGnomeEntity;
import net.Ntouz.corruptedore.entity.custom.MarrowderEntity;
import net.Ntouz.corruptedore.entity.custom.SmallStalwartGolemEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.storage.loot.LootDataType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.text.html.parser.Entity;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CorruptedOre.MOD_ID);

    public static final RegistryObject<EntityType<CorruptedGnomeEntity>> CORRUPTED_GNOME =
            ENTITY_TYPES.register("corrupted_gnome", () -> EntityType.Builder.of(CorruptedGnomeEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.5f).build("corrupted_gnome"));

    public static final RegistryObject<EntityType<SmallStalwartGolemEntity>> SMALL_STALWART_GOLEM =
            ENTITY_TYPES.register("small_stalwart_golem",
                    () -> EntityType.Builder.of(SmallStalwartGolemEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 0.84F) // width, height
                            .build("small_stalwart_golem"));

    public static final RegistryObject<EntityType<MarrowderEntity>> MARROWDER =
            ENTITY_TYPES.register("marrowder",
                    () -> EntityType.Builder.of(MarrowderEntity::new, MobCategory.MONSTER)
                            .sized(0.85F, 1.6F) // width, height
                            .build("marrowder"));



    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {

    }
}
