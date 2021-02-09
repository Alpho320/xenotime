package net.xenotime.actor

import net.xenotime.math.angle.Angle
import net.xenotime.math.vector.Vector3d
import net.xenotime.world.World

abstract class Actor {

    val world: World = TODO()

    val angle: Angle = TODO()
    val position: Vector3d = TODO()
}
