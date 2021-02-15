package net.xenotime.plugin

annotation class Plugin(
        val id: String,
        val api: String,
        val name: String,
        val version: String,
        val description: String = "",
        val authors: Array<String> = []
)
