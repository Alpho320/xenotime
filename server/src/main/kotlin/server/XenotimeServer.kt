package server

import api.player.PlayerManager
import api.server.Server
import api.world.WorldManager
import server.network.Network
import server.player.XenotimePlayerManager

class XenotimeServer : Server {

    override val players: PlayerManager = XenotimePlayerManager()
    override val worlds: WorldManager
        get() = TODO("Not yet implemented")

    private val network: Network = Network()

    override fun start() {
        network.start()

        while (true) { }
    }
}
