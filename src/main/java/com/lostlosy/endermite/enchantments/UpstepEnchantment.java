package com.lostlosy.endermite.enchantments;

import com.lostlosy.endermite.EndermiteMod;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class UpstepEnchantment extends Enchantment {

    public UpstepEnchantment(Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
        super(rarityIn, typeIn, slots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isAllowedOnBooks() {
        return true;
    }


    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return !ench.equals(Enchantments.DEPTH_STRIDER);
    }


   /* @Mod.EventBusSubscriber(modid = EndermiteMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class UpstepEquipped {

        @SubscribeEvent
        public static void doStuff(TickEvent.PlayerTickEvent Event) {
            PlayerEntity playerIn = Event.player;
            World worldIn = playerIn.world;

            worldIn.setBlockState(playerIn.getPosition().down(), Blocks.BARRIER.getDefaultState());

            if (playerIn.isCrouching()) {
                if (worldIn.getBlockState(playerIn.getPosition().down()).getBlock() == Blocks.BARRIER) {
                    worldIn.setBlockState(playerIn.getPosition(), Blocks.AIR.getDefaultState());
                    worldIn.setBlockState(playerIn.getPosition().down(), Blocks.BARRIER.getDefaultState());
                }
            }else {
                worldIn.setBlockState(playerIn.getPosition().down(), Blocks.BARRIER.getDefaultState());*/
            }