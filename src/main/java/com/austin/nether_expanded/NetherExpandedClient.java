package com.austin.nether_expanded;

import com.austin.nether_expanded.util.ModModelPredicateProvider;
import com.austin.nether_expanded.screen.ForgeScreen;
import com.austin.nether_expanded.screen.ModScreenHandlers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class NetherExpandedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModScreenHandlers.FORGE_SCREEN_HANDLER, ForgeScreen::new);

        ModModelPredicateProvider.registerModels();
    }
}
