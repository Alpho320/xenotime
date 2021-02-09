package net.xenotime.network.game.proto

import net.xenotime.network.game.proto.codec.GameProtoReader
import net.xenotime.network.game.proto.codec.GameProtoWriter
import net.xenotime.network.proto.NetworkPacket

abstract class GamePacket(packet: GameProto) : NetworkPacket<GameProtoReader, GameProtoWriter>(packet.id()) {

    abstract override fun encode(writer: GameProtoWriter)

    abstract override fun decode(reader: GameProtoReader)
}
