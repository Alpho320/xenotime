package net.xenotime.math.vector

class Vector2d(x: Double, y: Double) : Vector2<Double>(x, y) {

    init {
        positions = doubleArrayOf(x, y).toTypedArray()
    }
}
