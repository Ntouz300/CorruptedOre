package net.Ntouz.corruptedore.item;

import net.Ntouz.corruptedore.CorruptedOre;
import net.Ntouz.corruptedore.entity.ModEntities;
import net.Ntouz.corruptedore.item.custom.*;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CorruptedOre.MOD_ID );

    public static final RegistryObject<Item> CORRUPTEDGEM = ITEMS.register("corruptedgem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PUREGEM = ITEMS.register("puregem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CORRUPTEDFRAGMENT = ITEMS.register("corruptedfragment",
            () -> new FuelItem(new Item.Properties(), 600));

    public static final RegistryObject<Item> PURIFYING_ORB = ITEMS.register("purifying_orb",
            () -> new PurifierItem(new Item.Properties().durability(2)));

    public static final RegistryObject<Item> CORRUPTED_APPLE = ITEMS.register("corrupted_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.CORRUPTED_APPLE)));

    public static final RegistryObject<Item> PURE_APPLE = ITEMS.register("pure_apple",
            () -> new Item(new Item.Properties().food(ModFoodProperties.PURE_APPLE)));

    public static final RegistryObject<Item> CORRUPTED_SWORD = ITEMS.register("corrupted_sword",
            () -> new SwordItem(ModToolTiers.CORRUPTED, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.CORRUPTED, 3, -2.4f))));

    public static final RegistryObject<Item> CORRUPTED_PICKAXE = ITEMS.register("corrupted_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CORRUPTED, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CORRUPTED, 1, -2.8f))));

    public static final RegistryObject<Item> CORRUPTED_AXE = ITEMS.register("corrupted_axe",
            () -> new AxeItem(ModToolTiers.CORRUPTED, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CORRUPTED, 6, -3.2f))));

    public static final RegistryObject<Item> CORRUPTED_SHOVEL = ITEMS.register("corrupted_shovel",
            () -> new ShovelItem(ModToolTiers.CORRUPTED, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CORRUPTED, 1.5f, -3.0f))));

    public static final RegistryObject<Item> CORRUPTED_HOE = ITEMS.register("corrupted_hoe",
            () -> new HoeItem(ModToolTiers.CORRUPTED, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CORRUPTED, 0, -3.0f))));

    public static final RegistryObject<Item> CORRUPTED_HAMMER = ITEMS.register("corrupted_hammer",
            () -> new HammerItem(ModToolTiers.PURE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CORRUPTED, 7, -3.5f))));

    public static final RegistryObject<Item> PURE_SWORD = ITEMS.register("pure_sword",
            () -> new SwordItem(ModToolTiers.PURE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.PURE, 3, -2.4f))));

    public static final RegistryObject<Item> PURE_PICKAXE = ITEMS.register("pure_pickaxe",
            () -> new PickaxeItem(ModToolTiers.PURE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PURE, 1, -2.8f))));

    public static final RegistryObject<Item> PURE_AXE = ITEMS.register("pure_axe",
            () -> new AxeItem(ModToolTiers.PURE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.PURE, 6, -3.2f))));

    public static final RegistryObject<Item> PURE_SHOVEL = ITEMS.register("pure_shovel",
            () -> new ShovelItem(ModToolTiers.PURE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.PURE, 1.5f, -3.0f))));

    public static final RegistryObject<Item> PURE_HOE = ITEMS.register("pure_hoe",
            () -> new HoeItem(ModToolTiers.PURE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.PURE, 0, -3.0f))));

    public static final RegistryObject<Item> PURE_HAMMER = ITEMS.register("pure_hammer",
            () -> new HammerItem(ModToolTiers.PURE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.PURE, 7, -3.5f))));

    public static final RegistryObject<Item> CORRUPTED_HELMET = ITEMS.register("corrupted_helmet",
            () -> new ArmorItem(ModArmorMaterials.CORRUPTED_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(16))));

    public static final RegistryObject<Item> CORRUPTED_CHESTPLATE = ITEMS.register("corrupted_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CORRUPTED_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));

    public static final RegistryObject<Item> CORRUPTED_LEGGINGS = ITEMS.register("corrupted_leggings",
            () -> new ArmorItem(ModArmorMaterials.CORRUPTED_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(16))));

    public static final RegistryObject<Item> CORRUPTED_BOOTS = ITEMS.register("corrupted_boots",
            () -> new ArmorItem(ModArmorMaterials.CORRUPTED_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(16))));

    public static final RegistryObject<Item> PURE_HELMET = ITEMS.register("pure_helmet",
            () -> new ModArmorItem(ModArmorMaterials.PURE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(38))));

    public static final RegistryObject<Item> PURE_CHESTPLATE = ITEMS.register("pure_chestplate",
            () -> new ModArmorItem(ModArmorMaterials.PURE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(38))));

    public static final RegistryObject<Item> PURE_LEGGINGS = ITEMS.register("pure_leggings",
            () -> new ModArmorItem(ModArmorMaterials.PURE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(38))));

    public static final RegistryObject<Item> PURE_BOOTS = ITEMS.register("pure_boots",
            () -> new ModArmorItem(ModArmorMaterials.PURE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(38))));

    public static final RegistryObject<Item> CORRUPTED_HORSE_ARMOR = ITEMS.register("corrupted_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.CORRUPTED_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PURE_HORSE_ARMOR = ITEMS.register("pure_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.PURE_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> PURE_PAXEL = ITEMS.register("pure_paxel",
            () -> new PaxelItem(ModToolTiers.PURE, 1F, -2.8f,
                    new Item.Properties()
                            .attributes(PaxelItem.createAttributes(ModToolTiers.PURE, 1, -2.8f))));

    public static final RegistryObject<Item> CORRUPTED_PAXEL = ITEMS.register("corrupted_paxel",
            () -> new PaxelItem(ModToolTiers.CORRUPTED, 1F, -2.8f,
                    new Item.Properties()
                    .attributes(PaxelItem.createAttributes(ModToolTiers.PURE, 1, -2.8f))));

    public static final RegistryObject<Item> CORRUPTED_BOW = ITEMS.register("corrupted_bow",
            () -> new BowItem(new Item.Properties().durability(600)));

    public static final RegistryObject<Item> PURE_BOW = ITEMS.register("pure_bow",
            () -> new BowItem(new Item.Properties().durability(850)));

    public static final RegistryObject<Item> CORRUPTED_BATTLE_AXE = ITEMS.register("corrupted_battle_axe",
            () -> new BattleAxeItem(ModToolTiers.CORRUPTED, new Item.Properties()
                    .attributes(BattleAxeItem.createAttributes(ModToolTiers.CORRUPTED, 4, -2.6f))));

    public static final RegistryObject<Item> PURE_BATTLE_AXE = ITEMS.register("pure_battle_axe",
            () -> new SwordItem(ModToolTiers.PURE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.PURE, 4, -2.6f))));

    public static final RegistryObject<Item> CORRUPTED_GNOME_EGG = ITEMS.register("corrupted_gnome_egg",
            () -> new ForgeSpawnEggItem(ModEntities.CORRUPTED_GNOME, 0x26413c, 0x3f515c, new Item.Properties()));

    public static final RegistryObject<Item> PURE_INGOT = ITEMS.register("pure_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CORRUPTED_INGOT = ITEMS.register("corrupted_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> STALWART_PAXEL = ITEMS.register("stalwart_paxel",
            () -> new StalwartPaxelItem(ModToolTiers.STALWART, 2F, -2.0f,
                    new Item.Properties()
                            .attributes(PaxelItem.createAttributes(ModToolTiers.STALWART, 2, -2.0f))));

    public static final RegistryObject<Item> SMALL_STALWART_GOLEM_SPAWN_EGG = ITEMS.register("small_stalwart_golem_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.SMALL_STALWART_GOLEM, 0x319094, 0xa3f5ff, new Item.Properties()));

    public static final RegistryObject<Item> MARROWDER_EGG = ITEMS.register("marrowder_egg",
            () -> new ForgeSpawnEggItem(ModEntities.MARROWDER, 0x828282, 0xbe9595, new Item.Properties()));










    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
