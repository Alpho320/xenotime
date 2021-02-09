package net.xenotime.player

import net.xenotime.actor.types.living.humanoid.HumanoidActor
import net.xenotime.math.angle.Angle
import net.xenotime.math.vector.Vector3d
import net.xenotime.network.game.session.GameSession
import net.xenotime.world.World

class Player {

    var x: Double
        get() = actor.position.x
        set(value) { actor.position.x = value }

    var y: Double
        get() = actor.position.y
        set(value) { actor.position.y = value }

    var z: Double
        get() = actor.position.z
        set(value) { actor.position.z = value }

    var yaw: Float
        get() = actor.angle.yaw
        set(value) { actor.angle.yaw = value }

    var pitch: Float
        get() = actor.angle.pitch
        set(value) { actor.angle.pitch = value }

    val world: World
        get() = actor.world

    val angle: Angle
        get() = actor.angle

    val position: Vector3d
        get() = actor.position

    val actor: HumanoidActor = TODO()
    private val session: GameSession = TODO()
}
