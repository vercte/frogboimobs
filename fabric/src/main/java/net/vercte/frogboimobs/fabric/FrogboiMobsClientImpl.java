package net.vercte.frogboimobs.fabric;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.vercte.frogboimobs.FrogboiMobsClient;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class FrogboiMobsClientImpl {
    public static <E extends Entity> void registerRenderer(EntityType<E> entity, EntityRendererProvider<E> renderer) {
        EntityRendererRegistry.register(entity, renderer);
    }

    public static void registerModel(ModelLayerLocation layer, Supplier<LayerDefinition> provider) {
        EntityModelLayerRegistry.registerModelLayer(layer, provider::get);
    }

    public static <T extends ParticleOptions> void registerParticle(ParticleType<T> particleType, ParticleProvider<T> provider) {
        ParticleFactoryRegistry.getInstance().register(particleType, provider);
    }

    public static <T extends ParticleOptions> void registerParticle(ParticleType<T> particleType, FrogboiMobsClient.PendingParticleFactory<T> provider) {
        ParticleFactoryRegistry.getInstance().register(particleType, provider::create);
    }
}
