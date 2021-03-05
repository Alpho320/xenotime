package api.actor

import api.math.angle.Angle
import api.math.vector.Vector3f
import api.world.World

interface Actor {

    val world: World

    val angle: Angle
    val position: Vector3f
}
