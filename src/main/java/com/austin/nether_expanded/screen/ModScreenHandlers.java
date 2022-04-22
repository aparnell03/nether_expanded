package com.austin.nether_expanded.screen;

import com.austin.nether_expanded.NetherExpanded;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<ForgeScreenHandler> FORGE_SCREEN_HANDLER =
            ScreenHandlerRegistry.registerSimple(new Identifier(NetherExpanded.MOD_ID, "forge"),
                    ForgeScreenHandler::new);
}
