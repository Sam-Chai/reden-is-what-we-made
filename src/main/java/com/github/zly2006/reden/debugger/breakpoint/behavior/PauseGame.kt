package com.github.zly2006.reden.debugger.breakpoint.behavior

import com.github.zly2006.reden.access.ServerData.Companion.data
import com.github.zly2006.reden.debugger.breakpoint.BreakPoint
import com.github.zly2006.reden.debugger.tickPackets
import com.github.zly2006.reden.network.BreakPointInterrupt
import com.github.zly2006.reden.network.GlobalStatus
import com.github.zly2006.reden.network.StageTreeS2CPacket
import com.github.zly2006.reden.transformers.sendToAll
import com.github.zly2006.reden.utils.server

class PauseGame: BreakPointBehavior() {
    init {
        priority = 100
    }
    override fun onBreakPoint(breakPoint: BreakPoint, event: Any) {
        val tree = server.data().tickStageTree
        server.sendToAll(BreakPointInterrupt(breakPoint.id, tree))

        server.sendToAll(StageTreeS2CPacket(tree))
        server.data().addStatus(GlobalStatus.FROZEN)
        while (server.data().hasStatus(GlobalStatus.FROZEN)) {
            tickPackets(server)
        }

        server.sendToAll(BreakPointInterrupt(breakPoint.id, tree, false))
    }
}