package net.Ntouz.corruptedore.event;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.ModEntities;
import net.Ntouz.corruptedore.entity.client.CorruptedGnomeModel;
import net.Ntouz.corruptedore.entity.client.SmallStalwartGolemModel;
import net.Ntouz.corruptedore.entity.custom.CorruptedGnomeEntity;

import net.Ntouz.corruptedore.entity.custom.SmallStalwartGolemEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = CorruptedOre.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CorruptedGnomeModel.LAYER_LOCATION, CorruptedGnomeModel::createBodyLayer);
        event.registerLayerDefinition(SmallStalwartGolemModel.LAYER_LOCATION, SmallStalwartGolemModel::createBodyLayer);

    }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CORRUPTED_GNOME.get(), CorruptedGnomeEntity.createAttributes().build());
        event.put(ModEntities.SMALL_STALWART_GOLEM.get(), SmallStalwartGolemEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(SpawnPlacementRegisterEvent event) {
        event.register(ModEntities.CORRUPTED_GNOME.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.REPLACE);
        event.register(ModEntities.SMALL_STALWART_GOLEM.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SmallStalwartGolemEntity::canSpawnHere, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }
}

