package net.xenotime.network.wormhole.proto

import net.xenotime.network.proto.NetworkPacket
import net.xenotime.network.wormhole.proto.codec.WormholeProtoReader
import net.xenotime.network.wormhole.proto.codec.WormholeProtoWriter

abstract class WormholePacket(packet: WormholeProto) : NetworkPacket<WormholeProtoReader, WormholeProtoWriter>(packet.id()) {

    abstract override fun encode(writer: WormholeProtoWriter)

    abstract override fun decode(reader: WormholeProtoReader)
}
