package net.xenotime.network.wormhole.proto.packet

import net.xenotime.network.wormhole.proto.WormholePacket
import net.xenotime.network.wormhole.proto.WormholeProto
import net.xenotime.network.wormhole.proto.codec.WormholeProtoReader
import net.xenotime.network.wormhole.proto.codec.WormholeProtoWriter

class TestWormholePacket : WormholePacket(WormholeProto.Test) {

    override fun encode(writer: WormholeProtoWriter) {
        TODO("Not yet implemented")
    }

    override fun decode(reader: WormholeProtoReader) {
        TODO("Not yet implemented")
    }
}
