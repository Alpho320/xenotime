package api.player

import api.actor.types.living.humanoid.HumanoidActor

interface Player {

    val actor: HumanoidActor
}
