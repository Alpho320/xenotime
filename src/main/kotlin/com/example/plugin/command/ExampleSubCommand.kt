package com.example.plugin.command

import net.xenotime.command.CommandNode
import net.xenotime.text.TextResponse
import net.xenotime.command.annotation.Command
import net.xenotime.command.annotation.CommandExecutor
import net.xenotime.command.annotation.CommandParameter
import net.xenotime.player.Player

@Command(
        name = "examplesub",
        desc = "example subcommand"
)
class ExampleSubCommand : CommandNode() {

    @CommandExecutor
    fun execute(
            source: Player, output: TextResponse,
            @CommandParameter("example") example: Int
    ): TextResponse {
        output.info()
        output.append("Example line, player")
        output.append("used this command with $example param")
        return output
    }
}
