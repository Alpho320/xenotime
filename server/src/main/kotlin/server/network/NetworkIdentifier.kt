package server.network

import com.nukkitx.protocol.bedrock.BedrockPong
import com.nukkitx.protocol.bedrock.v428.Bedrock_v428

class NetworkIdentifier : BedrockPong() {

    init {
        ipv4Port = 19132
        playerCount = 0
        maximumPlayerCount = 20
        motd = "Test Server"
        subMotd = "Powered by Xenotime"

        edition = "MCPE"
        gameType = "Survival"
        version = Bedrock_v428.V428_CODEC.minecraftVersion
        protocolVersion = Bedrock_v428.V428_CODEC.protocolVersion
    }
}
