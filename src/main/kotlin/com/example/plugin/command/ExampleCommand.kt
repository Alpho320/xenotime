package com.example.plugin.command

import net.xenotime.command.annotation.Command
import net.xenotime.command.annotation.CommandExecutor
import net.xenotime.command.CommandNode
import net.xenotime.text.TextResponse
import net.xenotime.player.Player

@Command(
        name = "example",
        desc = "example command",
        nodes = [
            ExampleSubCommand::class
        ]
)
class ExampleCommand : CommandNode() {

    @CommandExecutor
    fun execute(source: Player, output: TextResponse): TextResponse {
        return output.warn("Please use '/help test' command to obtain more info about this command")
    }
}
