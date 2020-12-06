package com.lostlosy.endermite.init;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.enchantments.UpstepEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEnchantment {

    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, EndermiteMod.MOD_ID);

    public static final RegistryObject<Enchantment> UPSTEP = ENCHANTMENTS.register("upstep",
            () -> new UpstepEnchantment(Enchantment.Rarity.RARE, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[]
                    {EquipmentSlotType.FEET}));
}
