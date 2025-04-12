package net.vercte.frogboimobs.platform;

import net.vercte.frogboimobs.FrogboiMobs;
import net.vercte.frogboimobs.platform.services.IPlatformHelper;
import net.vercte.frogboimobs.platform.services.IRegistryHelper;

import java.util.ServiceLoader;

public class Services {
    public static final IPlatformHelper PLATFORM = load(IPlatformHelper.class);
    public static final IRegistryHelper REGISTRY = load(IRegistryHelper.class);

    public static <T> T load(Class<T> service) {
        final T loadedService = ServiceLoader.load(service)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + service.getName()));
        FrogboiMobs.LOGGER.debug("Loaded {} for service {}", loadedService, service);
        return loadedService;
    }
}
