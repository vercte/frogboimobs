package net.vercte.frogboimobs;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.vercte.frogboimobs.platform.content.entity.surprisecreeper.SurpriseCreeperModel;
import net.vercte.frogboimobs.platform.content.entity.surprisecreeper.SurpriseCreeperRenderer;
import net.vercte.frogboimobs.platform.content.visual.particle.ConfettiParticle;
import net.vercte.frogboimobs.platform.content.visual.particle.ConfettiParticleType;

import java.util.function.Supplier;

public class FrogboiMobsClient {
    public static void initialize() {}

    public static void registerRenderers() {
        registerRenderer(ModEntities.SURPRISE_CREEPER.get(), SurpriseCreeperRenderer.getProvider());
        registerModel(SurpriseCreeperRenderer.LAYER, SurpriseCreeperModel::createBodyLayer);
    }

    public static void registerParticles() {
        registerParticle(ModParticles.CONFETTI.get(), ConfettiParticle.Provider::new);
    }

    @ExpectPlatform
    public static <E extends Entity> void registerRenderer(EntityType<E> entity, EntityRendererProvider<E> renderer) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void registerModel(ModelLayerLocation layer, Supplier<LayerDefinition> provider) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends ParticleOptions> void registerParticle(T particleType, ParticleProvider<T> provider) {
        throw new AssertionError();
    }
}
