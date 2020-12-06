package com.lostlosy.endermite.init;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS  = new DeferredRegister<>(ForgeRegistries.BLOCKS, EndermiteMod.MOD_ID);

    public static final RegistryObject<Block> ENDERITE_BLOCK = BLOCKS.register("enderite_block", enderiteblock::new);
    public static final RegistryObject<Block> ENDERITE_ORE_BLOCK = BLOCKS.register("enderite_ore_block", EnderiteOreBlock::new);
    public static final RegistryObject<Block> NETHERITE_BLOCK = BLOCKS.register("netherite_block", NetheriteBlock::new);
    public static final RegistryObject<Block> ENDERITE_WORKBENCH = BLOCKS.register("enderite_workbench", EnderiteWorkBench::new);
    public static final RegistryObject<Block> ANCIENT_DEBRIS = BLOCKS.register("ancient_debris", AncientDebris::new);
    public static final RegistryObject<Block> QUARRY = BLOCKS.register("quarry", Quarry::new);
    public static final RegistryObject<Block> ENDERITE_BARREL = BLOCKS.register("enderite_barrel", EnderiteBarrel::new);
    public static final RegistryObject<Block> EXAMPLE_CROP = BLOCKS.register("example_crop",
            () -> new ExampleCrop(Block.Properties.from(Blocks.WHEAT)));
    public static final RegistryObject<Block> ENDERITE_GLASS = BLOCKS.register("enderite_glass", EnderiteGlass::new);
    public static final RegistryObject<Block> ENDERITE_GRASS = BLOCKS.register("enderite_grass", EnderiteGrass::new);
    public static final RegistryObject<Block> ENDERITE_DIRT = BLOCKS.register("enderite_dirt", EnderiteDirt::new);

}