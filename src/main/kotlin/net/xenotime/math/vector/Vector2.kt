package net.xenotime.math.vector

abstract class Vector2<T : Number>(x: T, y: T) : Vector<T>() {

    var x: T
        get() = positions[0]
        set(value) { positions[0] = value }

    var y: T
        get() = positions[1]
        set(value) { positions[1] = value }
}
