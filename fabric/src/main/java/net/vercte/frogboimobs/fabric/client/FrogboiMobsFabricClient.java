package net.vercte.frogboimobs.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.vercte.frogboimobs.FrogboiMobsClient;

public final class FrogboiMobsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FrogboiMobsClient.initialize();
        FrogboiMobsClient.registerRenderers();
    }
}
