package api.math.angle

import api.math.MathUtils

class Angle(yaw: Float, pitch: Float) {

    var yaw: Float = MathUtils.wrapDegrees(yaw)
        set(value) { field = MathUtils.wrapDegrees(value) }
    var pitch: Float = MathUtils.wrapDegrees(pitch)
        set(value) { field = MathUtils.wrapDegrees(value) }
}
