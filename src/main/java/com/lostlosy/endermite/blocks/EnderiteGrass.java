package com.lostlosy.endermite.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;


public class EnderiteGrass extends Block {
    public EnderiteGrass() {
        super(Block.Properties.create(Material.ORGANIC)
                .hardnessAndResistance(0.6F)
                .sound(SoundType.PLANT)
                .harvestLevel(0));
    }
}
