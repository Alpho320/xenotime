package api.server

import api.player.PlayerManager
import api.world.WorldManager

interface Server {

    val players: PlayerManager
    val worlds: WorldManager

    fun start() {}

    companion object {
        val instance: Server
            get() = ServerHolder.instance
    }
}
