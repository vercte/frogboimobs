package net.vercte.frogboimobs;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public final class FrogboiMobs {
    public static final String MOD_ID = "frogboimobs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static void initialize() {
        ModBlocks.initialize();
        ModEntities.initalize();
        ModParticles.initialize();
    }

    public static ResourceLocation asResource(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }
}
