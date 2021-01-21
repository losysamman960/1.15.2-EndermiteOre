package com.lostlosy.endermite.init;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.items.*;
import com.lostlosy.endermite.util.enums.ModArmorMaterial;
import com.lostlosy.endermite.util.enums.ModItemTier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, EndermiteMod.MOD_ID);

    // Items
    public static final RegistryObject<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", ItemBase::new);
    public static final RegistryObject<EnchantedEnderiteApple> ENCHANTED_ENDERITE_APPLE = ITEMS.register("enchanted_enderite_apple", EnchantedEnderiteApple::new);
    public static final RegistryObject<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", () -> new Item(new Item.Properties().group(EndermiteMod.TAB)));
    public static final RegistryObject<Item> NETHERITE_INGOT = ITEMS.register("netherite_ingot", ItemBase::new);
    public static final RegistryObject<Item> NETHERITE_SCRAP = ITEMS.register("netherite_scrap", ItemBase::new);
    public static final RegistryObject<Item> ENDERITE_NUGGET = ITEMS.register("enderite_nugget", ItemBase::new);
    public static final RegistryObject<Item> SEED_ITEM = ITEMS.register("seed_item",
            ()-> new BlockItem(ModBlocks.EXAMPLE_CROP.get(), new Item.Properties().group(EndermiteMod.TAB1)));
    public static final RegistryObject<Item> ENDERITE_COAL = ITEMS.register("enderite_coal", EnderiteCoal::new);
    public static final RegistryObject<Item> ENDERITE_BUCKET = ITEMS.register("enderite_bucket",
            () -> new BucketItem(() -> ModFluid.ENDERMITE_FLUID.get(), new Item.Properties().group(EndermiteMod.TAB1).maxStackSize(1)));
    public static final RegistryObject<ModMusicDiscItem> PROMISES_DISC = ITEMS.register("disc_promises",
            () -> new ModMusicDiscItem(5, ModSounds.LAZY_PROMISES_MUSIC.get(),
                    new Item.Properties().group(EndermiteMod.TAB).maxStackSize(1).rarity(Rarity.RARE)));

    //Tools
    public static final RegistryObject<EnderiteBow> ENDERITE_BOW = ITEMS.register("enderite_bow",
            () -> new EnderiteBow(new Item.Properties().maxStackSize(2).group(EndermiteMod.TAB).maxDamage(30)));

    public static final RegistryObject<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword",
            () -> new SwordItem(ModItemTier.ENDERITE_INGOT, 1, -3.0F, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe",
            () -> new PickaxeItem(ModItemTier.ENDERITE_INGOT, 0, -2.4f, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> new
            AxeItem(ModItemTier.ENDERITE_INGOT, 3, -3.2F, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> new
            ShovelItem(ModItemTier.ENDERITE_INGOT, 0, -2.4F, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> new
            HoeItem(ModItemTier.ENDERITE_INGOT, -1.0F, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<SwordItem> NETHERITE_SWORD = ITEMS.register("netherite_sword",
            () -> new SwordItem(ModItemTier.NETHERITE_INGOT, 1, -2.0F, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<PickaxeItem> NETHERITE_PICKAXE = ITEMS.register("netherite_pickaxe", () -> new
            PickaxeItem(ModItemTier.NETHERITE_INGOT, 0, -2.2F, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<AxeItem> NETHERITE_AXE = ITEMS.register("netherite_axe", () -> new
            AxeItem(ModItemTier.NETHERITE_INGOT, 2, -3.0F, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ShovelItem> NETHERITE_SHOVEL = ITEMS.register("netherite_shovel", () -> new
            ShovelItem(ModItemTier.NETHERITE_INGOT, 0, -2.2F, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<HoeItem> NETHERITE_HOE = ITEMS.register("netherite_hoe", () -> new
            HoeItem(ModItemTier.NETHERITE_INGOT, -1.0F, new Item.Properties().group(EndermiteMod.TAB)));

    //Armor
    public static final RegistryObject<ArmorItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet", () -> new
            ArmorItem(ModArmorMaterial.ENDERITE_INGOT, EquipmentSlotType.HEAD, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate", () -> new
            ArmorItem(ModArmorMaterial.ENDERITE_INGOT, EquipmentSlotType.CHEST, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ArmorItem> ENDERITE_LEGGING = ITEMS.register("enderite_legging", () -> new
            ArmorItem(ModArmorMaterial.ENDERITE_INGOT, EquipmentSlotType.LEGS, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots", () -> new
            ArmorItem(ModArmorMaterial.ENDERITE_INGOT, EquipmentSlotType.FEET, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ArmorItem> NETHERITE_HELMET = ITEMS.register("netherite_helmet", () -> new
            ArmorItem(ModArmorMaterial.NETHERITE_INGOT, EquipmentSlotType.HEAD, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ArmorItem> NETHERITE_CHESTPLATE = ITEMS.register("netherite_chestplate", () -> new
            ArmorItem(ModArmorMaterial.NETHERITE_INGOT, EquipmentSlotType.CHEST, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ArmorItem> NETHERITE_LEGGING = ITEMS.register("netherite_legging", () -> new
            ArmorItem(ModArmorMaterial.NETHERITE_INGOT, EquipmentSlotType.LEGS, new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<ArmorItem> NETHERITE_BOOTS = ITEMS.register("netherite_boots", () -> new
            ArmorItem(ModArmorMaterial.NETHERITE_INGOT, EquipmentSlotType.FEET, new Item.Properties().group(EndermiteMod.TAB)));

    //Block Items
    public static final RegistryObject<Item> ENDERITE_BLOCK_ITEM = ITEMS.register("enderite_block",
            () -> new BlockItem(ModBlocks.ENDERITE_BLOCK.get(), new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<Item> ENDERITE_ORE_ITEM = ITEMS.register("enderite_ore_block",
            () -> new BlockItem(ModBlocks.ENDERITE_ORE_BLOCK.get(), new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<Item> NETHERITE_BLOCK_ITEM = ITEMS.register("netherite_block",
            () -> new BlockItem(ModBlocks.NETHERITE_BLOCK.get(), new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<Item> ENDERITE_WORKBENCH_ITEM = ITEMS.register("enderite_workbench",
            () -> new BlockItem(ModBlocks.ENDERITE_WORKBENCH.get(), new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<Item> ANCIENT_DEBRIS_ITEM = ITEMS.register("ancient_debris",
            () -> new BlockItem(ModBlocks.ANCIENT_DEBRIS.get(), new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<Item> QUARRY_ITEM = ITEMS.register("quarry",
            () -> new BlockItem(ModBlocks.QUARRY.get(), new Item.Properties().group(EndermiteMod.TAB1)));

    public static final RegistryObject<Item> ENDERITE_BARREL = ITEMS.register("enderite_barrel",
            () -> new BlockItem(ModBlocks.ENDERITE_BARREL.get(), new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<Item> ENDERITE_GLASS_ITEM = ITEMS.register("enderite_glass",
            () -> new BlockItem(ModBlocks.ENDERITE_GLASS.get(), new Item.Properties().group(EndermiteMod.TAB1)));

    public static final RegistryObject<Item> ENDERITE_DIRT = ITEMS.register("enderite_dirt",
            () -> new BlockItem(ModBlocks.ENDERITE_DIRT.get(), new Item.Properties().group(EndermiteMod.TAB)));

    public static final RegistryObject<Item> ENDERITE_GRASS_ITEM = ITEMS.register("enderite_grass",
            () -> new BlockItem(ModBlocks.ENDERITE_GRASS.get(), new Item.Properties().group(EndermiteMod.TAB1)));
}
