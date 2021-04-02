package server.network

import java.net.InetSocketAddress

import com.nukkitx.protocol.bedrock.BedrockServer

class Network {

    private val server: BedrockServer

    init {
        InetSocketAddress("192.168.1.33", 19132).let {
            server = BedrockServer(it).run {
                handler = NetworkListener(NetworkIdentifier())
                return@run this
            }
        }
    }

    fun start() {
        server.bind().join()
    }
}
