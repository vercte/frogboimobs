package net.vercte.frogboimobs;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.vercte.frogboimobs.platform.Services;
import net.vercte.frogboimobs.content.entity.surprisecreeper.SurpriseCreeper;

import java.util.HashMap;
import java.util.function.Supplier;

public class ModEntities {
    public static final Supplier<EntityType<SurpriseCreeper>> SURPRISE_CREEPER = register("surprise_creeper", EntityType.Builder.of(SurpriseCreeper::new, MobCategory.MONSTER)
            .sized(0.8f, 1).eyeHeight(10/16f).clientTrackingRange(8));

    public static HashMap<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> getAttributeSuppliers() {
        HashMap<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> map = new HashMap<>();
        map.put(SURPRISE_CREEPER.get(), SurpriseCreeper.createAttributes());
        return map;
    }

    public static <T extends Entity> Supplier<EntityType<T>> register(String id, EntityType.Builder<T> builder) {
        return Services.REGISTRY.register(BuiltInRegistries.ENTITY_TYPE, id, () -> builder.build(id));
    }

    public static void initalize() {}
}
