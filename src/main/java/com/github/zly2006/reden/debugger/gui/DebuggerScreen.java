package com.github.zly2006.reden.debugger.gui;

import com.github.zly2006.reden.Reden;
import io.wispforest.owo.ui.base.BaseOwoScreen;
import io.wispforest.owo.ui.component.Components;
import io.wispforest.owo.ui.container.Containers;
import io.wispforest.owo.ui.container.FlowLayout;
import io.wispforest.owo.ui.core.*;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Element;

public class DebuggerScreen extends BaseOwoScreen<FlowLayout> {

    @Override
    protected @NotNull OwoUIAdapter<FlowLayout> createAdapter() {
        return OwoUIAdapter.create(this, Containers::verticalFlow);
    }

    @Override
    protected void build(FlowLayout rootComponent) {
        // Init rootComponent at LEFT-TOP and a vanilla background
        rootComponent
                .surface(Surface.VANILLA_TRANSLUCENT)
                .horizontalAlignment(HorizontalAlignment.LEFT)
                .verticalAlignment(VerticalAlignment.TOP);
        rootComponent.gap(10);
        // Text layout
        layout(rootComponent);
        // Buttons
        rootComponent.child(
                Containers.verticalFlow(Sizing.content(), Sizing.content())
                        .child(Components.button(
                                Text.of("Step Info"),
                                (lambda) -> {}
                        ))
                        .padding(Insets.of(10))
                        .surface(Surface.DARK_PANEL)
                        .verticalAlignment(VerticalAlignment.CENTER)
                        .horizontalAlignment(HorizontalAlignment.CENTER)
        );
    }

    public FlowLayout layout(FlowLayout rootComponent) {
        rootComponent.child(
                Containers.verticalFlow(Sizing.content(), Sizing.content())
                        .gap(1)
                        .child(Components.label(Text.of("Reden Debugger " + Reden.MOD_VERSION)).shadow(true))
                        .child(Components.label(Text.of("[Update Stack]" )).shadow(true))
                        .child(Components.label(Text.of("[+] NC from [0,0,0] to [0,0,0]")).shadow(true))
                        .child(Components.label(Text.of("[+] PP from [0,0,0] to [0,0,0]")).shadow(true))
                        .child(Components.label(Text.of("[+] Projectfile Hit [ArrorEntity]: UUID")).shadow(true))
                        .child(Components.label(Text.of("[+] TickEntity [ArrorEntity]: UUID")).shadow(true))
                        .child(Components.label(Text.of("[+] TickEntities / Overworld")).shadow(true))
                        .child(Components.label(Text.of("[+] WorldTick / Overworld")).shadow(true))
                        .child(Components.label(Text.of("[+] ServerTick: 20")).shadow(true))
                        .child(Components.label(Text.of("[Info]")).shadow(true))
                        .child(Components.label(Text.of("Type: Breakpoint fired")).shadow(true))
                        .child(Components.label(Text.of("Breakpoint: Block Breakpoint at BlockPos[1,0,0]")).shadow(true))
                        .child(Components.label(Text.of("Breakpoint Type: NC[to], PP[from->to]")).shadow(true))

        );
        return rootComponent;
    }
}
