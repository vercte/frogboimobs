package net.vercte.frogboimobs.platform.content.visual.particle;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class ConfettiParticleType extends ParticleType<ConfettiParticleType> implements ParticleOptions {
    private final MapCodec<ConfettiParticleType> codec = MapCodec.unit(this::getType);
    private final StreamCodec<RegistryFriendlyByteBuf, ConfettiParticleType> streamCodec = StreamCodec.unit(this);

    public ConfettiParticleType(boolean bl) {
        super(bl);
    }

    public ConfettiParticleType getType() {
        return this;
    }

    public MapCodec<ConfettiParticleType> codec() {
        return this.codec;
    }

    public StreamCodec<RegistryFriendlyByteBuf, ConfettiParticleType> streamCodec() {
        return this.streamCodec;
    }
}
