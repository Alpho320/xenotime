package server.player

import api.player.Player
import api.player.PlayerManager
import java.util.concurrent.ConcurrentHashMap

class XenotimePlayerManager : PlayerManager {

    private val players: MutableMap<String, Player> = ConcurrentHashMap()

    override fun add(player: Player) {
        players[""] = player
    }

    override fun remove(player: Player) {
        players.remove("")
    }

    override fun get(xuid: String): Player? {
        return players[xuid]
    }
}
