package com.lostlosy.endermite.init;

import com.lostlosy.endermite.EndermiteMod;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModFluid {

    public static final ResourceLocation ENDERMITE_STILL_RL = new ResourceLocation(EndermiteMod.MOD_ID, "blocks/endermite_still");
    public static final ResourceLocation ENDERMITE_FLOWING_RL = new ResourceLocation(EndermiteMod.MOD_ID, "blocks/endermite_flowing");

    public static final ResourceLocation ENDERMITE_OVERLAY_RL = new ResourceLocation(EndermiteMod.MOD_ID, "blocks/endermite_overlay");

    public static final DeferredRegister<Fluid> FLUIDS =  new DeferredRegister<>(ForgeRegistries.FLUIDS, EndermiteMod.MOD_ID);

    public static final RegistryObject<FlowingFluid> ENDERMITE_FLUID = FLUIDS.register("endermite_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluid.ENDERMITE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> ENDERMITE_FLOWING = FLUIDS.register("endermite_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluid.ENDERMITE_PROPERTIES));

    public static final ForgeFlowingFluid.Properties ENDERMITE_PROPERTIES = new ForgeFlowingFluid.Properties(
            ()-> ENDERMITE_FLUID.get(), ()-> ENDERMITE_FLOWING.get(), FluidAttributes.builder(ENDERMITE_STILL_RL, ENDERMITE_FLOWING_RL)
            .density(5)
            .luminosity(10)
            .rarity(Rarity.RARE)
            .sound(SoundEvents.BLOCK_PORTAL_AMBIENT)
            .overlay(ENDERMITE_OVERLAY_RL)).block(() -> ModFluid.ENDERMITE_BLOCK.get())
            .bucket(ModItems.ENDERITE_BUCKET);

    public static final RegistryObject<FlowingFluidBlock> ENDERMITE_BLOCK = ModBlocks.BLOCKS.register("endermite", () -> new FlowingFluidBlock(() -> ModFluid.ENDERMITE_FLUID.get(), Block.Properties.create(Material.WATER)
            .doesNotBlockMovement()
            .hardnessAndResistance(100.0f)
            .noDrops()));
}
