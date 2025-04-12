package net.vercte.frogboimobs.neoforge.platform.services;

import net.neoforged.fml.loading.FMLLoader;
import net.vercte.frogboimobs.platform.services.IPlatformHelper;

public class NeoforgePlatformHelper implements IPlatformHelper {
    @Override
    public String getPlatformName() {
        return "neoforge";
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }
}

