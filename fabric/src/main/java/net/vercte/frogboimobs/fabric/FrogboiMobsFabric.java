package net.vercte.frogboimobs.fabric;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.vercte.frogboimobs.FrogboiMobs;
import net.fabricmc.api.ModInitializer;
import net.vercte.frogboimobs.ModEntities;

public final class FrogboiMobsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        FrogboiMobs.initialize();
        ModEntities.getAttributeSuppliers().forEach(FabricDefaultAttributeRegistry::register);
    }
}
