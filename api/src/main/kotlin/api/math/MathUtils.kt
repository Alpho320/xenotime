package api.math

object MathUtils {

    fun wrapDegrees(value: Float): Float {
        var temp = value
        temp %= 360.0f

        if (temp >= 180.0f) {
            temp -= 360.0f
        }
        if (temp < -180.0f) {
            temp += 360.0f
        }
        return temp
    }
}