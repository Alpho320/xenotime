package server.network.session

import com.nukkitx.protocol.bedrock.handler.BedrockPacketHandler
import com.nukkitx.protocol.bedrock.packet.ClientToServerHandshakePacket
import com.nukkitx.protocol.bedrock.packet.LoginPacket
import com.nukkitx.protocol.bedrock.packet.ResourcePackClientResponsePacket

class NetworkSessionListener(private val session: NetworkSession) : BedrockPacketHandler {

    override fun handle(packet: LoginPacket): Boolean {
        session.handshake()
        return true
    }

    override fun handle(packet: ClientToServerHandshakePacket): Boolean {
        session.playstatus()
        session.rpinfo()
        return true
    }

    override fun handle(packet: ResourcePackClientResponsePacket): Boolean {
        session.startgame()
        return true
    }
}
