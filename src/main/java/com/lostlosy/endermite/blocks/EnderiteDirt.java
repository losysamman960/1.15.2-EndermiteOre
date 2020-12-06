package com.lostlosy.endermite.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnderiteDirt extends Block {
    public EnderiteDirt() {
        super(Block.Properties.create(Material.EARTH)
                .hardnessAndResistance(0.5f)
                .sound(SoundType.GROUND));
    }
}
