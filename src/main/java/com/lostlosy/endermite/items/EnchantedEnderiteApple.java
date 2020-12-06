package com.lostlosy.endermite.items;

import com.lostlosy.endermite.EndermiteMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class EnchantedEnderiteApple extends Item {


    public EnchantedEnderiteApple() {
        super(new Item.Properties()
                .group(EndermiteMod.TAB)
                .food(new Food.Builder()
                        .saturation(2)
                        .hunger(4)
                        .effect(() -> new EffectInstance(Effects.ABSORPTION, 2400, 1), 0.5f)
                        .effect(() -> new EffectInstance(Effects.RESISTANCE, 2400, 2), 0.2f)
                        .effect(() -> new EffectInstance(Effects.SATURATION, 200, 1), 0.3f)
                        .effect(() -> new EffectInstance(Effects.NIGHT_VISION, 2400, 1), 1.0f)
                        .effect(() -> new EffectInstance(Effects.REGENERATION, 400, 1), 1.0f)
                        .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 400, 1), 1.0f)
                        .effect(() -> new EffectInstance(Effects.INSTANT_DAMAGE, 400, 30), 1.0f)
                        .setAlwaysEdible()
                        .build()));

    }

    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}



