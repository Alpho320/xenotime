package net.xenotime.math.vector

open class Vector3f(x: Float, y: Float, z: Float) : Vector3<Float>(x, y, z) {

    init {
        positions = floatArrayOf(x, y, z).toTypedArray()
    }
}
