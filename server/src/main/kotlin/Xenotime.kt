import api.server.Server
import api.server.ServerHolder
import server.XenotimeServer

fun main() {
    val server: Server = XenotimeServer().run {
        ServerHolder.instance = this
        return@run this
    }

    try {
        server.start()
    } catch (e: Exception) {

    }
}
