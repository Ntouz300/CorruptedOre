package net.Ntouz.corruptedore.block;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.block.custom.PurifierSource;
import net.Ntouz.corruptedore.block.custom.StalwartGolemHead;
import net.Ntouz.corruptedore.block.custom.StalwartPumpkin;
import net.Ntouz.corruptedore.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // CRÉATION DES BLOCKS
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CorruptedOre.MOD_ID);

    public static final RegistryObject<Block> CORRUPTED_BLOCK = registerBlock("corrupted_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> PURE_BLOCK = registerBlock("pure_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RICH_CORRUPTED_ORE = registerBlock("rich_corrupted_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 3), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> RICH_PURE_ORE = registerBlock("rich_pure_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 2), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> CORRUPTED_END_ORE = registerBlock("corrupted_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> PURE_END_ORE = registerBlock("pure_end_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 3), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> PURE_NETHER_ORE = registerBlock("pure_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 1), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_NETHER_ORE = registerBlock("corrupted_nether_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 1), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PURE_ORE = registerBlock("pure_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 1), BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CORRUPTED_ORE = registerBlock("corrupted_ore",
            () -> new DropExperienceBlock(UniformInt.of(1, 1), BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> PURIFIER_BLOCK = registerBlock("purifier_block",
            () -> new PurifierSource(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<StairBlock> CORRUPTED_STAIRS = registerBlock("corrupted_stairs",
            () -> new StairBlock(ModBlocks.CORRUPTED_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<SlabBlock> CORRUPTED_SLAB = registerBlock("corrupted_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<PressurePlateBlock> CORRUPTED_PRESSURE_PLATE = registerBlock("corrupted_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<ButtonBlock> CORRUPTED_BUTTON = registerBlock("corrupted_button",
            () -> new ButtonBlock(BlockSetType.IRON, 5, BlockBehaviour.Properties.of().strength(3f)
                    .requiresCorrectToolForDrops().noCollission()));

    public static final RegistryObject<FenceBlock> CORRUPTED_FENCE = registerBlock("corrupted_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<FenceGateBlock> CORRUPTED_FENCE_GATE = registerBlock("corrupted_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<WallBlock> CORRUPTED_WALL = registerBlock("corrupted_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<DoorBlock> CORRUPTED_DOOR = registerBlock("corrupted_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<TrapDoorBlock> CORRUPTED_TRAPDOOR = registerBlock("corrupted_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<StalwartGolemHead> SALWART_GOLEM_HEAD = registerBlock("stalwart_golem_head",
            () -> new StalwartGolemHead(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.HARD_CROP)));

    public static final RegistryObject<StalwartPumpkin> STALWART_PUMPKIN = registerBlock("stalwart_pumpkin",
            () -> new StalwartPumpkin(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.HARD_CROP)));





    // FONCTIONS ET AUTRES POUR LES BLOCKS
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
