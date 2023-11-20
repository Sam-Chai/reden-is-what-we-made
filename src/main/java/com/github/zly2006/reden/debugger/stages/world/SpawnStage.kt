package com.github.zly2006.reden.debugger.stages.world

import com.github.zly2006.reden.debugger.TickStage
import com.github.zly2006.reden.debugger.stages.WorldRootStage

class SpawnStage(
    val _parent: WorldRootStage
): TickStage("spawn", _parent) {
}
