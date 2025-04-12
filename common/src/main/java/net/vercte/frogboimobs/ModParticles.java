package net.vercte.frogboimobs;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.vercte.frogboimobs.platform.Services;
import net.vercte.frogboimobs.platform.content.visual.particle.ConfettiParticleType;

import java.util.function.Supplier;

public class ModParticles {
    public static final Supplier<ConfettiParticleType> CONFETTI = register("confetti", new ConfettiParticleType(false));

    public static <T extends ParticleType<?>> Supplier<T> register(String id, T particle) {
        return Services.REGISTRY.register(BuiltInRegistries.PARTICLE_TYPE, id, () -> particle);
    }

    public static void initialize() {}
}
