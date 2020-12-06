package com.lostlosy.endermite.init;

import com.lostlosy.endermite.EndermiteMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSounds {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, EndermiteMod.MOD_ID);

    public static final Lazy<SoundEvent> LAZY_PROMISES_MUSIC = Lazy
            .of(() -> new SoundEvent(new ResourceLocation(EndermiteMod.MOD_ID, "disc.promises")));

    public static final RegistryObject<SoundEvent> PROMISES_MUSIC = SOUNDS.register("promises_music",
            LAZY_PROMISES_MUSIC);
}
