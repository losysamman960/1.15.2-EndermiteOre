package com.lostlosy.endermite.util;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.init.DimensionInit;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndermiteMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubscriber {

    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event) {
        if (DimensionType.byName(EndermiteMod.EXAMPLE_DIM_TYPE) == null) {
            DimensionManager.registerDimension(EndermiteMod.EXAMPLE_DIM_TYPE, DimensionInit.EXAMPLE_DIM.get(), null, true);
        }
        EndermiteMod.LOGGER.info("Dimensions Registered!");
    }
}
