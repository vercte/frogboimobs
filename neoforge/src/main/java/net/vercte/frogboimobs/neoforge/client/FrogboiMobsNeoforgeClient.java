package net.vercte.frogboimobs.neoforge.client;

import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.vercte.frogboimobs.FrogboiMobsClient;

public class FrogboiMobsNeoforgeClient {
    public static void onClientSetup(FMLClientSetupEvent event) {
        FrogboiMobsClient.initialize();
        FrogboiMobsClient.registerRenderers();
        event.enqueueWork(FrogboiMobsClient::registerItemProperties);
    }
}
