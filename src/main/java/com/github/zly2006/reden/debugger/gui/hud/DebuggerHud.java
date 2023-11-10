package com.github.zly2006.reden.debugger.gui.hud;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class DebuggerHud implements HudRenderCallback {
    public static DebuggerHud INSTANCE;
    public static boolean visible;

    public static void init() {
        INSTANCE = new DebuggerHud();
        HudRenderCallback.EVENT.register(INSTANCE);
    }

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        MinecraftClient client = MinecraftClient.getInstance();
        DebuggerLayout debuggerLayout = new DebuggerLayout(10, 10, client);
        if (visible && client.currentScreen == null) {
            debuggerLayout.render(drawContext);
        }

    }
}
