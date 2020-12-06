package com.lostlosy.endermite.items;

import com.lostlosy.endermite.EndermiteMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EnderiteCoal extends Item {

    public EnderiteCoal() {
        super(new Properties().group(EndermiteMod.TAB1));
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 800;
    }
}
