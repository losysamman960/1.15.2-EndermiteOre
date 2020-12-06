package com.lostlosy.endermite.util.enums;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.init.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum ModArmorMaterial implements IArmorMaterial {

    ENDERITE_INGOT(EndermiteMod.MOD_ID + ":enderite_ingot", 40, new int[] { 6, 5, 7, 2 }, 20,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 2.0F, () -> { return Ingredient.fromItems(ModItems.ENDERITE_INGOT.get());
    }),

    NETHERITE_INGOT(EndermiteMod.MOD_ID + ":netherite_ingot", 37, new int[] { 6, 5, 7, 2 }, 15,
            SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.0F, () -> { return Ingredient.fromItems(ModItems.NETHERITE_INGOT.get());
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 15, 16, 13 };
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;

    ModArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial) {

        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}
