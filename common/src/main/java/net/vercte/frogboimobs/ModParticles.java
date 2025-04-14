package net.vercte.frogboimobs;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.vercte.frogboimobs.platform.Services;
import net.vercte.frogboimobs.content.visual.particle.ParticleUtils;

import java.util.function.Supplier;

public class ModParticles {
    public static final Supplier<SimpleParticleType> CONFETTI = register("confetti", ParticleUtils.simpleParticle(true));

    public static <T extends ParticleType<?>> Supplier<T> register(String id, T particle) {
        return Services.REGISTRY.register(BuiltInRegistries.PARTICLE_TYPE, id, () -> particle);
    }

    public static void initialize() {}
}
