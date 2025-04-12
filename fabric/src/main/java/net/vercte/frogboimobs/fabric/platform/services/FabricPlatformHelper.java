package net.vercte.frogboimobs.fabric.platform.services;

import net.fabricmc.loader.api.FabricLoader;
import net.vercte.frogboimobs.platform.services.IPlatformHelper;

public class FabricPlatformHelper implements IPlatformHelper {
    @Override
    public String getPlatformName() {
        return "fabric";
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }
}
