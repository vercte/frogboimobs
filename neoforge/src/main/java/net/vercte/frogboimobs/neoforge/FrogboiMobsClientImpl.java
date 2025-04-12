package net.vercte.frogboimobs.neoforge;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.client.ClientHooks;

import java.util.function.Supplier;

public class FrogboiMobsClientImpl {
    public static <E extends Entity> void registerRenderer(EntityType<E> entity, EntityRendererProvider<E> renderer) {
        EntityRenderers.register(entity, renderer);
    }

    public static void registerModel(ModelLayerLocation layer, Supplier<LayerDefinition> provider) {
        ClientHooks.registerLayerDefinition(layer, provider);
    }
}
