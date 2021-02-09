package net.xenotime.network.game.proto.packet

import net.xenotime.network.game.proto.GamePacket
import net.xenotime.network.game.proto.GameProto
import net.xenotime.network.game.proto.codec.GameProtoReader
import net.xenotime.network.game.proto.codec.GameProtoWriter

class PlayStatusPacket : GamePacket(GameProto.PlayStatus) {

    override fun encode(writer: GameProtoWriter) {
        TODO("Not yet implemented")
    }

    override fun decode(reader: GameProtoReader) {
        TODO("Not yet implemented")
    }
}
