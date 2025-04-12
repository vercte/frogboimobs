package net.vercte.frogboimobs.fabric;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

import java.util.function.Supplier;

public class FrogboiMobsClientImpl {
    public static <E extends Entity> void registerRenderer(EntityType<E> entity, EntityRendererProvider<E> renderer) {
        EntityRendererRegistry.register(entity, renderer);
    }

    public static void registerModel(ModelLayerLocation layer, Supplier<LayerDefinition> provider) {
        EntityModelLayerRegistry.registerModelLayer(layer, provider::get);
    }
}
