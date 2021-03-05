package net.xenotime.command.annotation

import net.xenotime.command.CommandNode
import kotlin.reflect.KClass

annotation class Command(
        val name: String,
        val desc: String,
        val roles: Array<String> = [],
        val nodes: Array<KClass<out CommandNode>> = []
)
