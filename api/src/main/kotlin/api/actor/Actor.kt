package api.actor

import api.math.angle.Angle
import api.math.vector.Vector3f
import api.world.World

abstract class Actor {

    val world: World = TODO()

    val angle: Angle = TODO()
    val position: Vector3f = TODO()
}
