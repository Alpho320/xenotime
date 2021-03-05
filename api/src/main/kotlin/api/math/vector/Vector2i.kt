package api.math.vector

open class Vector2i(x: Int, y: Int) : Vector2<Int>(x, y) {

    init {
        positions = intArrayOf(x, y).toTypedArray()
    }
}
