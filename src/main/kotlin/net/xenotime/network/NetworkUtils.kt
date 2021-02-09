package net.xenotime.network

import net.xenotime.network.game.proto.GamePacket
import net.xenotime.network.game.proto.GameProto
import net.xenotime.network.wormhole.proto.WormholePacket
import net.xenotime.network.wormhole.proto.WormholeProto
import java.util.*

object NetworkUtils {

    object Game {
        fun newPacket(id: Byte): GamePacket? {
            GameProto.values().filter {
                it.id() == id
            }.let {
                return if (it.size == 1) {
                    it.first().reference().constructors.first().call()
                } else {
                    null
                }
            }
        }
    }

    object Wormhole {
        fun newPacket(id: Byte): WormholePacket? {
            WormholeProto.values().filter {
                it.id() == id
            }.let {
                return if (it.size == 1) {
                    it.first().reference().constructors.first().call()
                } else {
                    null
                }
            }
        }
    }
}
