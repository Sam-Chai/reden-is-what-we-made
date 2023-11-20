package com.github.zly2006.reden.access

import com.github.zly2006.reden.debugger.stages.WorldRootStage
import com.github.zly2006.reden.debugger.stages.world.BlockEventsRootStage
import net.minecraft.server.world.BlockEvent
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World

class WorldData(
    val serverWorld: ServerWorld
): StatusAccess {
    override var status: Long = 0
    lateinit var tickStage: WorldRootStage
    @JvmField var tickingBlockEvent: BlockEvent? = null
    @JvmField var blockEventsRootStage: BlockEventsRootStage? = null

    interface WorldDataAccess {
        fun getRedenWorldData(): WorldData
    }

    companion object {
        @JvmStatic
        fun ServerWorld.data(): WorldData {
            return (this as WorldDataAccess).getRedenWorldData()
        }
        @JvmStatic
        fun World.data(): WorldData? {
            return (this as? ServerWorld)?.data()
        }
    }
}
