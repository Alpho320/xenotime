package com.example.plugin

import net.xenotime.plugin.Plugin
import net.xenotime.plugin.PluginContext

@Plugin(
        id = "example-plugin",
        api = "1.0.0",
        name = "Example Plugin",
        version = "1.0.0",
        description = "This is an test Plugin for Xenotime Server Software",
        authors = [
            "eminarican"
        ]
)
class ExamplePlugin : PluginContext() {

}
