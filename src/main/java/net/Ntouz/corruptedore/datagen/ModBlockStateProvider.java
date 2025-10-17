package net.Ntouz.corruptedore.datagen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.block.custom.StalwartGolemHead;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CorruptedOre.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.PURE_BLOCK);
        blockWithItem(ModBlocks.CORRUPTED_BLOCK);
        blockWithItem(ModBlocks.CORRUPTED_ORE);
        blockWithItem(ModBlocks.PURE_ORE);

        blockWithItem(ModBlocks.RICH_CORRUPTED_ORE);
        blockWithItem(ModBlocks.RICH_PURE_ORE);

        blockWithItem(ModBlocks.CORRUPTED_NETHER_ORE);
        blockWithItem(ModBlocks.PURE_NETHER_ORE);
        blockWithItem(ModBlocks.CORRUPTED_END_ORE);
        blockWithItem(ModBlocks.PURE_END_ORE);

        blockWithItem(ModBlocks.PURIFIER_BLOCK);

        stairsBlock(ModBlocks.CORRUPTED_STAIRS.get(), blockTexture(ModBlocks.CORRUPTED_BLOCK.get()));
        slabBlock(ModBlocks.CORRUPTED_SLAB.get(), blockTexture(ModBlocks.CORRUPTED_BLOCK.get()), blockTexture(ModBlocks.CORRUPTED_BLOCK.get()));

        buttonBlock(ModBlocks.CORRUPTED_BUTTON.get(), blockTexture(ModBlocks.CORRUPTED_BLOCK.get()));
        pressurePlateBlock(ModBlocks.CORRUPTED_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CORRUPTED_BLOCK.get()));

        fenceBlock(ModBlocks.CORRUPTED_FENCE.get(), blockTexture(ModBlocks.CORRUPTED_BLOCK.get()));
        fenceGateBlock(ModBlocks.CORRUPTED_FENCE_GATE.get(), blockTexture(ModBlocks.CORRUPTED_BLOCK.get()));
        wallBlock(ModBlocks.CORRUPTED_WALL.get(), blockTexture(ModBlocks.CORRUPTED_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.CORRUPTED_DOOR.get(), modLoc("block/corrupted_door_bottom"), modLoc("block/corrupted_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.CORRUPTED_TRAPDOOR.get(), modLoc("block/corrupted_trapdoor"), true, "cutout");

        blockItem(ModBlocks.CORRUPTED_STAIRS);
        blockItem(ModBlocks.CORRUPTED_SLAB);
        blockItem(ModBlocks.CORRUPTED_PRESSURE_PLATE);
        blockItem(ModBlocks.CORRUPTED_FENCE_GATE);
        blockItem(ModBlocks.CORRUPTED_TRAPDOOR, "_bottom");

        blockWithCustomFacesAndFront(ModBlocks.SALWART_GOLEM_HEAD.get(), "stalwart_golem_head");
        blockWithCustomFacesAndFront(ModBlocks.STALWART_PUMPKIN.get(), "stalwart_pumpkin");

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("corruptedore:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("corruptedore:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }

    private void blockWithCustomFacesAndFront(Block block, String name) {
        ResourceLocation side = modLoc("block/" + name + "_side");
        ResourceLocation front = modLoc("block/" + name + "_front");
        ResourceLocation top = modLoc("block/" + name + "_top");
        ResourceLocation bottom = modLoc("block/" + name + "_bottom");

        ModelFile model = models().withExistingParent(name, mcLoc("block/orientable_with_bottom"))
                .texture("side", side)
                .texture("front", front)
                .texture("top", top)
                .texture("bottom", bottom);
        simpleBlock(block, model);

        itemModels().withExistingParent(name, modLoc("block/" + name));
    }
}
