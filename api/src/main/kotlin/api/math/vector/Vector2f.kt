package api.math.vector

open class Vector2f(x: Float, y: Float) : Vector2<Float>(x, y) {

    init {
        positions = floatArrayOf(x, y).toTypedArray()
    }
}
