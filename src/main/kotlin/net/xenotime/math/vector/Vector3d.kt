package net.xenotime.math.vector

class Vector3d(x: Double, y: Double, z: Double) : Vector3<Double>(x, y, z) {

    init {
        positions = doubleArrayOf(x, y, z).toTypedArray()
    }
}
