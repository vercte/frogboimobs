package net.vercte.frogboimobs.platform.content.visual.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

public class ConfettiParticle extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected ConfettiParticle(ClientLevel clientLevel, double d, double e, double f, double x, double y, double z, SpriteSet spriteSet) {
        super(clientLevel, d, e, f);
        this.gravity = 0.225f;
        this.friction = 1.0f;
        this.sprites = spriteSet;
        this.xd = x + (Math.random() * 2.0f - 1.0f) * 0.1f;
        this.yd = y + (Math.random() * 1.0f) * 0.1f + 0.1f;
        this.zd = z + (Math.random() * 2.0f - 1.0f) * 0.1f;
        this.quadSize = 0.1f * (this.random.nextFloat() * this.random.nextFloat() * 1.0f + 1.0f);
        this.lifetime = 80 + (int)(this.random.nextFloat() * 40f);
        this.setSpriteFromAge(spriteSet);
    }

    public void tick() {
        super.tick();
        this.setSpriteFromAge(this.sprites);
        this.xd *= 0.95f;
        this.yd *= 0.9f;
        this.zd *= 0.95f;
    }

    @Override
    @NotNull
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType simpleParticleType, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            return new ConfettiParticle(clientLevel, d, e, f, g, h, i, this.sprites);
        }
    }
}
