package com.mas6y6.horzion.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "horzion");

    public static final RegistryObject<SoundEvent> SPAMTRACK = SOUND_EVENTS.register("bigshot", 
        () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("horzion", "bigshot"))
    );
}