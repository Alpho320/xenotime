package server.network.session

import com.nukkitx.math.vector.Vector2f
import com.nukkitx.math.vector.Vector3f
import com.nukkitx.math.vector.Vector3i
import com.nukkitx.protocol.bedrock.BedrockSession
import com.nukkitx.protocol.bedrock.data.inventory.ItemData

import com.nukkitx.protocol.bedrock.data.AuthoritativeMovementMode

import com.nukkitx.protocol.bedrock.data.SyncedPlayerMovementSettings

import com.nukkitx.protocol.bedrock.data.PlayerPermission

import com.nukkitx.protocol.bedrock.data.GamePublishSetting

import com.nukkitx.protocol.bedrock.data.GameRuleData

import com.nukkitx.protocol.bedrock.data.GameType

import com.nukkitx.protocol.bedrock.data.AttributeData

import java.util.ArrayList

import com.nukkitx.protocol.bedrock.data.inventory.ContainerId

import java.io.IOException

import com.nukkitx.nbt.NbtUtils

import com.nukkitx.nbt.NBTOutputStream

import java.io.ByteArrayOutputStream

import com.nukkitx.nbt.NbtMap
import com.nukkitx.protocol.bedrock.packet.*

class NetworkSession(private val connection: BedrockSession) {

    private val listener: NetworkSessionListener = NetworkSessionListener(this)

    private val EMPTY_TAG = NbtMap.EMPTY
    private var EMPTY_LEVEL_CHUNK_DATA: ByteArray

    init {
        try {
            ByteArrayOutputStream().use { outputStream ->
                outputStream.write(ByteArray(258)) // Biomes + Border Size + Extra Data Size
                NbtUtils.createNetworkWriter(outputStream).use { stream -> stream.writeTag(EMPTY_TAG) }
                EMPTY_LEVEL_CHUNK_DATA = outputStream.toByteArray()
            }
        } catch (e: IOException) {
            throw AssertionError("Unable to generate empty level chunk data")
        }

        connection.packetHandler = listener
    }

    fun handshake() {
        println("hanshake")
        connection.sendPacketImmediately(ServerToClientHandshakePacket())
    }

    fun playstatus() {
        PlayStatusPacket().let {
            it.status = PlayStatusPacket.Status.LOGIN_SUCCESS
            connection.sendPacketImmediately(it)
        }
    }

    fun rpinfo() {
        connection.sendPacketImmediately(ResourcePacksInfoPacket())
    }

    fun rpstack() {
        connection.sendPacketImmediately(ResourcePackStackPacket())
    }

    fun startgame() {
        val mp = MovePlayerPacket()
        mp.runtimeEntityId = 1
        mp.isOnGround = false
        mp.mode = MovePlayerPacket.Mode.NORMAL
        mp.rotation = Vector3f.from(0.0, 0.0, 0.0)
        mp.position = Vector3f.from(0.0, 0.0, 0.0)
        connection.sendPacketImmediately(mp)

        val startGamePacket = StartGamePacket()
        startGamePacket.uniqueEntityId = 1
        startGamePacket.runtimeEntityId = 1
        startGamePacket.playerGameType = GameType.SURVIVAL
        startGamePacket.playerPosition = Vector3f.from(0.0, 0.0, 0.0)
        startGamePacket.rotation = Vector2f.from(1.0, 1.0)

        startGamePacket.seed = -1
        startGamePacket.dimensionId = 0
        startGamePacket.generatorId = 1
        startGamePacket.levelGameType = GameType.SURVIVAL
        startGamePacket.difficulty = 1
        startGamePacket.defaultSpawn = Vector3i.ZERO
        startGamePacket.isAchievementsDisabled = false
        startGamePacket.currentTick = -1
        //startGamePacket.setUnknownInt0(-1);
        //startGamePacket.setUnknownInt1(-1);
        //startGamePacket.setUnknownInt0(-1);
        //startGamePacket.setUnknownInt1(-1);
        startGamePacket.eduEditionOffers = 0
        startGamePacket.isEduFeaturesEnabled = false
        startGamePacket.rainLevel = 0f
        startGamePacket.lightningLevel = 0f
        //startGamePacket.setPlatformLockedContentConfirmed(false);
        //startGamePacket.setPlatformLockedContentConfirmed(false);
        startGamePacket.isMultiplayerGame = true
        startGamePacket.isBroadcastingToLan = true
        startGamePacket.gamerules.add(GameRuleData("showcoordinates", false))
        startGamePacket.platformBroadcastMode = GamePublishSetting.PUBLIC
        startGamePacket.xblBroadcastMode = GamePublishSetting.PUBLIC
        startGamePacket.isCommandsEnabled = true
        startGamePacket.isTexturePacksRequired = false
        startGamePacket.isBonusChestEnabled = false
        startGamePacket.isStartingWithMap = false
        startGamePacket.isTrustingPlayers = true
        startGamePacket.defaultPlayerPermission = PlayerPermission.MEMBER
        startGamePacket.serverChunkTickRange = 4
        startGamePacket.isBehaviorPackLocked = false
        startGamePacket.isResourcePackLocked = false
        startGamePacket.isFromLockedWorldTemplate = false
        startGamePacket.isUsingMsaGamertagsOnly = false
        startGamePacket.isFromWorldTemplate = false
        startGamePacket.isWorldTemplateOptionLocked = false

        //startGamePacket.setOnlySpawningV1Villagers(false);

        //startGamePacket.setOnlySpawningV1Villagers(false);
        startGamePacket.authoritativeMovementMode = AuthoritativeMovementMode.CLIENT
        val settings = SyncedPlayerMovementSettings()
        settings.movementMode = AuthoritativeMovementMode.CLIENT
        settings.rewindHistorySize = 0
        settings.isServerAuthoritativeBlockBreaking = false
        startGamePacket.playerMovementSettings = settings
        //startGamePacket.setTrial(false);
        //startGamePacket.setTrial(false);
        startGamePacket.vanillaVersion = "*"

        startGamePacket.levelId = "world"
        startGamePacket.levelName = "world"
        //startGamePacket.setWorldName("world");
        //startGamePacket.setWorldName("world");
        startGamePacket.premiumWorldTemplateId = "00000000-0000-0000-0000-000000000000"
        startGamePacket.currentTick = 0
        startGamePacket.enchantmentSeed = 0
        startGamePacket.multiplayerCorrelationId = ""

        //startGamePacket.blockPalette =

        connection.sendPacketImmediately(startGamePacket)

        val creativeContentPacket = CreativeContentPacket()
        creativeContentPacket.contents = arrayOfNulls(0)
        connection.sendPacketImmediately(creativeContentPacket)

        val pos = Vector3f.ZERO
        val chunkX = pos.floorX shr 4
        val chunkZ = pos.floorX shr 4

        for (x in -3..2) {
            for (z in -3..2) {
                val data2 = LevelChunkPacket()
                data2.chunkX = chunkX + x
                data2.chunkZ = chunkZ + z
                data2.subChunksLength = 0
                data2.data = EMPTY_LEVEL_CHUNK_DATA
                connection.sendPacketImmediately(data2)
            }
        }

        //val biomePacket = BiomeDefinitionListPacket()
        //biomePacket.definitions =
        //connection.sendPacket(biomePacket)

        //val entityPacket = AvailableEntityIdentifiersPacket()
        //entityPacket.identifiers =
        //connection.sendPacket(entityPacket)

        //val creativePacket = InventoryContentPacket()
        //creativePacket.containerId = ContainerId.CREATIVE
        //creativePacket.contents =
       // connection.sendPacket(creativePacket)

        val playStatus = PlayStatusPacket()
        playStatus.status = PlayStatusPacket.Status.PLAYER_SPAWN
        connection.sendPacketImmediately(playStatus)

        val attributesPacket = UpdateAttributesPacket()
        attributesPacket.runtimeEntityId = 0
        val attributes: MutableList<AttributeData> = ArrayList()
        attributes.add(AttributeData("minecraft:movement", 0.0f, 1024f, 0.1f, 0.1f))
        attributesPacket.attributes = attributes
        connection.sendPacketImmediately(attributesPacket)
    }
}
