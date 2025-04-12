package net.vercte.frogboimobs.platform.services;

import net.minecraft.core.Registry;

import java.util.function.Supplier;

public interface IRegistryHelper {
    <T> Supplier<T> register(Registry<? super T> registry, String id, Supplier<T> object);


}
