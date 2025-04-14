package net.vercte.frogboimobs.neoforge.client;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.vercte.frogboimobs.FrogboiMobsClient;

public class FrogboiMobsNeoforgeClient {
    public static void onClientSetup(FMLClientSetupEvent ignoredEvent) {
        FrogboiMobsClient.initialize();
        FrogboiMobsClient.registerRenderers();
    }
}
