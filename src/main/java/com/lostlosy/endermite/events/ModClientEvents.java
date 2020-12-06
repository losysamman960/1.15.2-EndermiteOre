package com.lostlosy.endermite.events;

import com.lostlosy.endermite.EndermiteMod;
import com.lostlosy.endermite.init.ModItems;
import net.minecraft.advancements.criterion.PlacedBlockTrigger;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndermiteMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onDamagePlayer(AttackEntityEvent event) {
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.ENDERITE_SWORD.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof SheepEntity) {

                    PlayerEntity player = event.getPlayer();
                    target.addPotionEffect(new EffectInstance(Effects.WITHER, 5 * 20));
                    target.setNoGravity(true);
                    if (event.getPlayer().getEntityWorld().isRemote) {
                        String msg = TextFormatting.DARK_RED + "you just got destroyed";
                        player.sendMessage(new StringTextComponent(msg));
                    }
                }
            }
        }
    }
    }

