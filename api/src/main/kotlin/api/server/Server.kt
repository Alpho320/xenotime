package api.server

import api.player.PlayerManager
import api.world.WorldManager

interface Server {

    val instance: Server
        get() = ServerHolder.instance

    val players: PlayerManager
    val worlds: WorldManager

    fun start() {}
}
