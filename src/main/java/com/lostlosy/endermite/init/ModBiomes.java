package com.lostlosy.endermite.init;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.world.biome.EnderiteBiome;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomes {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, EndermiteMod.MOD_ID);

    public static final RegistryObject<Biome> ENDERITE_BIOME = BIOMES.register("enderite_biome", () -> new EnderiteBiome(new Biome.Builder()
            .precipitation(Biome.RainType.SNOW)
            .scale(1.2f)
            .temperature(0.5f)
            .waterColor(9568511)
            .waterFogColor(12026879)
            .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(ModBlocks.ENDERITE_GRASS.get().getDefaultState(), ModBlocks.ENDERITE_DIRT.get().getDefaultState(), ModBlocks.ENDERITE_DIRT.get().getDefaultState()))
            .category(Biome.Category.PLAINS)
            .downfall(0.5f)
            .depth(0.12f)
            //This does not parent with any biome not like how bambo parents of the jungle
            .parent(null)));

    public static void registerBiomes() {
        registerBiome(ENDERITE_BIOME.get(), Type.PLAINS, Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, Type... types) {
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
