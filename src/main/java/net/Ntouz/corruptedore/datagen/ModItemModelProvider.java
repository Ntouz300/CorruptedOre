package net.Ntouz.corruptedore.datagen;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.block.ModBlocks;
import net.Ntouz.corruptedore.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CorruptedOre.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.PUREGEM.get());
        basicItem(ModItems.CORRUPTEDGEM.get());

        basicItem(ModItems.CORRUPTEDFRAGMENT.get());
        basicItem(ModItems.CORRUPTED_APPLE.get());
        basicItem(ModItems.PURE_APPLE.get());

        basicItem(ModItems.CORRUPTED_HORSE_ARMOR.get());
        basicItem(ModItems.PURE_HORSE_ARMOR.get());

        basicItem(ModItems.CORRUPTED_INGOT.get());
        basicItem(ModItems.PURE_INGOT.get());

        buttonItem(ModBlocks.CORRUPTED_BUTTON, ModBlocks.CORRUPTED_BLOCK);
        fenceItem(ModBlocks.CORRUPTED_FENCE, ModBlocks.CORRUPTED_BLOCK);
        wallItem(ModBlocks.CORRUPTED_WALL, ModBlocks.CORRUPTED_BLOCK);

        simpleBlockItem(ModBlocks.CORRUPTED_DOOR);

        handheldItem(ModItems.CORRUPTED_SWORD);
        handheldItem(ModItems.CORRUPTED_PICKAXE);
        handheldItem(ModItems.CORRUPTED_SHOVEL);
        handheldItem(ModItems.CORRUPTED_AXE);
        handheldItem(ModItems.CORRUPTED_HOE);

        handheldItem(ModItems.PURE_SWORD);
        handheldItem(ModItems.PURE_PICKAXE);
        handheldItem(ModItems.PURE_SHOVEL);
        handheldItem(ModItems.PURE_AXE);
        handheldItem(ModItems.PURE_HOE);

        handheldItem(ModItems.CORRUPTED_BATTLE_AXE);
        handheldItem(ModItems.CORRUPTED_HAMMER);
        handheldItem(ModItems.PURE_HAMMER);

        handheldItem(ModItems.PURE_BATTLE_AXE);
        handheldItem(ModItems.CORRUPTED_PAXEL);
        handheldItem(ModItems.PURE_PAXEL);

        trimmedArmorItem(ModItems.CORRUPTED_HELMET);
        trimmedArmorItem(ModItems.CORRUPTED_CHESTPLATE);
        trimmedArmorItem(ModItems.CORRUPTED_LEGGINGS);
        trimmedArmorItem(ModItems.CORRUPTED_BOOTS);

        trimmedArmorItem(ModItems.PURE_HELMET);
        trimmedArmorItem(ModItems.PURE_CHESTPLATE);
        trimmedArmorItem(ModItems.PURE_LEGGINGS);
        trimmedArmorItem(ModItems.PURE_BOOTS);

        handheldItem(ModItems.STALWART_PAXEL);

        withExistingParent(ModItems.CORRUPTED_GNOME_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.SMALL_STALWART_GOLEM_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

    }
    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = CorruptedOre.MOD_ID; // Change this to your mod id

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }

    public void buttonItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<? extends Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(CorruptedOre.MOD_ID, "item/" + item.getId().getPath()));
    }
}
