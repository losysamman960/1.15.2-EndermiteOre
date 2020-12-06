package com.lostlosy.endermite.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AncientDebris extends Block {
    public AncientDebris() {
        super(Block.Properties.create(Material.IRON)
        .hardnessAndResistance(8.0f, 20.0f)
        .sound(SoundType.METAL)
        .harvestLevel(3)
        .harvestTool(ToolType.PICKAXE));
    }
}
