package net.vercte.frogboimobs.fabric.platform.services;

import net.minecraft.core.Registry;
import net.vercte.frogboimobs.FrogboiMobs;
import net.vercte.frogboimobs.platform.services.IRegistryHelper;

import java.util.function.Supplier;

public class FabricRegistryHelper implements IRegistryHelper {
    @Override
    public <T> Supplier<T> register(Registry<? super T> registry, String id, Supplier<T> item) {
        T value = Registry.register(registry, FrogboiMobs.asResource(id), item.get());
        return () -> value;
    }
}
