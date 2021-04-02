package server.network

import api.server.Server
import com.nukkitx.protocol.bedrock.BedrockPong
import com.nukkitx.protocol.bedrock.BedrockServerEventHandler
import com.nukkitx.protocol.bedrock.BedrockServerSession
import server.network.session.NetworkSession
import server.network.session.NetworkSessionListener
import server.player.XenotimePlayer
import java.net.InetSocketAddress

class NetworkListener(private val identifier: NetworkIdentifier) : BedrockServerEventHandler {

    override fun onQuery(address: InetSocketAddress): BedrockPong {
        return identifier
    }

    override fun onConnectionRequest(address: InetSocketAddress): Boolean {
        return true
    }

    override fun onSessionCreation(serverSession: BedrockServerSession) {
        println("connected ${serverSession.address}")
        XenotimePlayer(NetworkSession(serverSession)).let {
            Server.instance.players.add(it)
        }
    }
}
