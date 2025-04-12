package net.vercte.frogboimobs.platform.content.visual.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import org.jetbrains.annotations.NotNull;

public class ConfettiParticle extends TextureSheetParticle {
    private final SpriteSet sprites;

    protected ConfettiParticle(ClientLevel clientLevel, double d, double e, double f, double x, double y, double z, SpriteSet spriteSet) {
        super(clientLevel, d, e, f);
        this.gravity = 0.225f;
        this.friction = 1.0f;
        this.sprites = spriteSet;
        this.xd = x + (Math.random() * (double)2.0f - (double)1.0f) * (double)0.05f;
        this.yd = y + (Math.random() * (double)2.0f - (double)1.0f) * (double)0.05f;
        this.zd = z + (Math.random() * (double)2.0f - (double)1.0f) * (double)0.05f;
        this.quadSize = 0.1f * (this.random.nextFloat() * this.random.nextFloat() * 1.0f + 1.0f);
        this.lifetime = (int)(16.0f / (this.random.nextFloat() * 0.8 + 0.2)) + 2;
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

    @Environment(EnvType.CLIENT)
    public static class Provider implements ParticleProvider<ConfettiParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(ConfettiParticleType simpleParticleType, ClientLevel clientLevel, double d, double e, double f, double g, double h, double i) {
            ConfettiParticle confetti = new ConfettiParticle(clientLevel, d, e, f, g, h, i, this.sprites);
            confetti.setColor(0.923F, 0.964F, 0.999F);
            return confetti;
        }
    }
}
