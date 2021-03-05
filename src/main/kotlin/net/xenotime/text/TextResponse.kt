package net.xenotime.text

class TextResponse {

    private var lines: MutableList<String> = ArrayList()
    private var type: ResponseTypes = ResponseTypes.INFO

    fun info() = type(ResponseTypes.INFO)
    fun warn() = type(ResponseTypes.WARN)
    fun error() = type(ResponseTypes.ERROR)
    fun system() = type(ResponseTypes.SYSTEM)
    fun success() = type(ResponseTypes.SUCCESS)

    fun info(message: String): TextResponse {
        info()
        message(message)
        return this
    }

    fun warn(message: String): TextResponse {
        warn()
        message(message)
        return this
    }

    fun error(message: String): TextResponse {
        error()
        message(message)
        return this
    }

    fun system(message: String): TextResponse {
        system()
        message(message)
        return this
    }

    fun success(message: String): TextResponse {
        success()
        message(message)
        return this
    }

    fun append(message: String) {
        lines[lines.size] = message
    }

    private fun message(message: String) {
        lines = arrayListOf(message)
    }

    private fun type(type: ResponseTypes) {
        this.type = type
    }
}
