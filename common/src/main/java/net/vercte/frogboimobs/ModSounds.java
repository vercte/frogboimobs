package net.vercte.frogboimobs;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.vercte.frogboimobs.platform.Services;

import java.util.function.Supplier;

public class ModSounds {
    public static final Supplier<SoundEvent> PARTY_HORN = register("party_horn");

    public static Supplier<SoundEvent> register(String id) {
        return Services.REGISTRY.register(BuiltInRegistries.SOUND_EVENT, id, () -> SoundEvent.createVariableRangeEvent(FrogboiMobs.asResource(id)));
    }

    public static void initialize() {}
}
