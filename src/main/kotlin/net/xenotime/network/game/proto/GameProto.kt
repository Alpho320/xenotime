package net.xenotime.network.game.proto

import net.xenotime.network.game.proto.packet.*
import kotlin.reflect.KClass

enum class GameProto(private val id: Byte, private val reference: KClass<out GamePacket>) {
    Login(0x01, LoginPacket::class),
    PlayStatus(0x02, PlayStatusPacket::class),
    HandshakeServerToClient(0x03, HandshakeServerToClientPacket::class),
    HandshakeClientToServer(0x04, HandshakeClientToServerPacket::class),

    Batch(0xff.toByte(), BatchPacket::class);

    fun id(): Byte {
        return this.id
    }

    fun reference(): KClass<out GamePacket> {
        return this.reference
    }
}
