package com.lostlosy.endermite.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnderiteGlass extends Block {
    public EnderiteGlass() {
        super(Block.Properties.create(Material.GLASS)
                .hardnessAndResistance(0.3f)
                .sound(SoundType.GLASS)
                .notSolid());
    }
}
