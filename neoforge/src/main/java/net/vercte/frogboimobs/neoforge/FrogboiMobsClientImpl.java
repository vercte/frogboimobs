package net.vercte.frogboimobs.neoforge;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.client.ClientHooks;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.vercte.frogboimobs.FrogboiMobsClient;

import java.util.HashMap;
import java.util.function.Supplier;

@SuppressWarnings({"rawtypes", "unused"})
public class FrogboiMobsClientImpl {
    public static <E extends Entity> void registerRenderer(EntityType<E> entity, EntityRendererProvider<E> renderer) {
        EntityRenderers.register(entity, renderer);
    }

    public static void registerModel(ModelLayerLocation layer, Supplier<LayerDefinition> provider) {
        ClientHooks.registerLayerDefinition(layer, provider);
    }


    private static final HashMap<ParticleType, ParticleProvider> PARTICLE_PROVIDERS = new HashMap<>();
    private static final HashMap<ParticleType, ParticleEngine.SpriteParticleRegistration> PARTICLE_PROVIDERS_SPRITE = new HashMap<>();

    public static <T extends ParticleOptions> void registerParticle(ParticleType<T> particleType, ParticleProvider<T> provider) {
        PARTICLE_PROVIDERS.put(particleType, provider);
    }

    public static <T extends ParticleOptions> void registerParticle(ParticleType<T> particleType, FrogboiMobsClient.PendingParticleFactory<T> provider) {
        PARTICLE_PROVIDERS_SPRITE.put(particleType, provider::create);
    }

    public static void registerFactory(RegisterParticleProvidersEvent event) {
        FrogboiMobsClient.registerParticles();
        PARTICLE_PROVIDERS.forEach(event::registerSpecial);
        PARTICLE_PROVIDERS_SPRITE.forEach(event::registerSpriteSet);
    }
}
