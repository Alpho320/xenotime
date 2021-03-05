package net.xenotime.command.annotation

annotation class CommandParameter(
        val name: String,
        val args: Array<String> = [],
        val optional: Boolean = false
)
