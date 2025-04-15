package net.vercte.frogboimobs;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.vercte.frogboimobs.content.entity.surprisecreeper.SurpriseCreeperModel;
import net.vercte.frogboimobs.content.entity.surprisecreeper.SurpriseCreeperRenderer;
import net.vercte.frogboimobs.content.effect.particle.ConfettiParticle;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class FrogboiMobsClient {
    public static void initialize() {}

    public static void registerItemProperties() {
        ItemProperties.register(ModItems.PARTY_HORN.get(),
                FrogboiMobs.asResource("tooting"), (stack, level, living, id) -> living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0F : 0.0F);
    }

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
    public static <T extends ParticleOptions> void registerParticle(ParticleType<T> particleType, ParticleProvider<T> provider) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static <T extends ParticleOptions> void registerParticle(ParticleType<T> particleType, PendingParticleFactory<T> provider) {
        throw new AssertionError();
    }

    @FunctionalInterface
    public interface PendingParticleFactory<T extends ParticleOptions> {
        ParticleProvider<T> create(SpriteSet set);
    }
}
