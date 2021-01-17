package com.lostlosy.endermite;

import com.lostlosy.endermite.init.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod("em")
@Mod.EventBusSubscriber(modid = EndermiteMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EndermiteMod {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "em";
    //The code down is for Dimensions
    public static final ResourceLocation EXAMPLE_DIM_TYPE = new ResourceLocation(MOD_ID, "example");

    public EndermiteMod() {
        //Registers to modEventBus
        MinecraftForge.EVENT_BUS.register(this);
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        //Registry
        //ModParticles.PARTICLE_TYPES.register(modEventBus);
        ModSounds.SOUNDS.register(modEventBus);
        //ModPotions.POTIONS.register(modEventBus);
        //ModPotions.POTIONS_EFFECTS.register(modEventBus);
        ModEnchantment.ENCHANTMENTS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModFluid.FLUIDS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
        ModContainerTypes.CONTAINER_TYPES.register(modEventBus);
        ModBiomes.BIOMES.register(modEventBus);
        DimensionInit.MOD_DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());


    }
    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
        ModBiomes.registerBiomes();
    }
    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    public static final ItemGroup TAB = new ItemGroup("Endermite") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ENDERITE_INGOT.get());
        }
    };
    public static final ItemGroup TAB1 = new ItemGroup("Test_Tab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.ENDERITE_NUGGET.get());
        }
    };

}

