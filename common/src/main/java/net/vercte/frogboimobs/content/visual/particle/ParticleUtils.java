package net.vercte.frogboimobs.content.visual.particle;

import net.minecraft.core.particles.SimpleParticleType;

public class ParticleUtils {
    public static SimpleParticleType simpleParticle(boolean bl) {
        return new SimpleParticleType(bl) {};
    }
}
