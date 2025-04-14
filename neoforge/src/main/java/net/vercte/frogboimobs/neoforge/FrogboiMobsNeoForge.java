package net.vercte.frogboimobs.neoforge;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.vercte.frogboimobs.FrogboiMobs;
import net.neoforged.fml.common.Mod;
import net.vercte.frogboimobs.ModEntities;
import net.vercte.frogboimobs.neoforge.client.FrogboiMobsNeoforgeClient;
import net.vercte.frogboimobs.neoforge.platform.services.NeoforgeRegistryHelper;

import java.util.HashMap;

@Mod(FrogboiMobs.MOD_ID)
public final class FrogboiMobsNeoForge {
    public FrogboiMobsNeoForge(IEventBus bus) {
        FrogboiMobs.initialize();

        bus.addListener(FrogboiMobsNeoforgeClient::onClientSetup);
        bus.addListener(FrogboiMobsClientImpl::registerFactory);
        bus.addListener(this::registerEntityAttributes);
        NeoforgeRegistryHelper.registerAll(bus);
    }

    public void registerEntityAttributes(EntityAttributeCreationEvent event) {
        HashMap<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> map = ModEntities.getAttributeSuppliers();
        for(var entry : map.entrySet()) {
            event.put(entry.getKey(), entry.getValue().build());
        }
    }
}
