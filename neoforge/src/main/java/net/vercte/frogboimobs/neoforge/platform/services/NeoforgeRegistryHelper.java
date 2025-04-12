package net.vercte.frogboimobs.neoforge.platform.services;

import net.minecraft.core.Registry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.vercte.frogboimobs.FrogboiMobs;
import net.vercte.frogboimobs.platform.services.IRegistryHelper;

import java.util.HashMap;
import java.util.function.Supplier;

public class NeoforgeRegistryHelper implements IRegistryHelper {
    private static final HashMap<Registry<?>, DeferredRegister<?>> REGISTERS = new HashMap<>();

    @Override
    public <T> Supplier<T> register(Registry<? super T> registry, String id, Supplier<T> item) {
        return getOrCreateRegistrar(registry).register(id, item);
    }

    private <T> DeferredRegister<T> getOrCreateRegistrar(Registry<T> registry) {
        DeferredRegister<T> existing = (DeferredRegister<T>) REGISTERS.get(registry);
        if(existing != null) return existing;

        DeferredRegister<T> created = DeferredRegister.create(registry, FrogboiMobs.MOD_ID);
        REGISTERS.put(registry, created);
        return created;
    }

    public static void registerAll(IEventBus bus) {
        REGISTERS.forEach((r, d) -> {
            d.register(bus);
        });
    }
}
