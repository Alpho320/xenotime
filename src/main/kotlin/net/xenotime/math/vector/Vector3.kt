package net.xenotime.math.vector

abstract class Vector3<T : Number>(x: T, y: T, z: T) : Vector<T>() {

    var x: T
        get() = positions[0]
        set(value) { positions[0] = value }

    var y: T
        get() = positions[1]
        set(value) { positions[1] = value }

    var z: T
        get() = positions[2]
        set(value) { positions[2] = value }
}
