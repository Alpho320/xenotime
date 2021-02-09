package net.xenotime.network.wormhole.proto

import net.xenotime.network.wormhole.proto.packet.TestWormholePacket
import kotlin.reflect.KClass

enum class WormholeProto(private val id: Byte, private val reference: KClass<out WormholePacket>) {
    Test(0x0, TestWormholePacket::class);

    fun id(): Byte {
        return this.id
    }

    fun reference(): KClass<out WormholePacket> {
        return this.reference
    }
}
