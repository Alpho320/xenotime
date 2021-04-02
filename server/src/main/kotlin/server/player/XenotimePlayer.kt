package server.player

import api.actor.types.living.humanoid.HumanoidActor
import api.player.Player
import server.network.NetworkSession

class XenotimePlayer(private val session: NetworkSession) : Player {

    override val actor: HumanoidActor = TODO()
}
