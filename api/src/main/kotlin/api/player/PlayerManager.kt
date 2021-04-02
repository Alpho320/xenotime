package api.player

interface PlayerManager {

    fun add(player: Player)
    fun remove(player: Player)
    fun get(xuid: String): Player?
}
