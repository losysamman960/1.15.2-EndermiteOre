package com.lostlosy.endermite.util;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.client.gui.EnderiteBarrelScreen;
import com.lostlosy.endermite.init.ModBlocks;
import com.lostlosy.endermite.init.ModContainerTypes;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = EndermiteMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ScreenManager.registerFactory(ModContainerTypes.ENDERITE_BARREL.get(), EnderiteBarrelScreen::new);
        RenderTypeLookup.setRenderLayer(ModBlocks.EXAMPLE_CROP.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(ModBlocks.ENDERITE_GLASS.get(), RenderType.getCutout());
    }
}
