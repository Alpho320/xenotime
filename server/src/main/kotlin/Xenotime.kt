import api.server.Server
import server.XenotimeServer

fun main() {
    val server: Server = XenotimeServer()

    try {
        server.start()
    } catch (e: Exception) {

    }
}
