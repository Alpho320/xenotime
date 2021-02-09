package net.xenotime.math.vector

open class Vector3i(x: Int, y: Int, z: Int) : Vector3<Int>(x, y, z) {

    init {
        positions = intArrayOf(x, y, z).toTypedArray()
    }
}
