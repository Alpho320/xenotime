package com.example.plugin

import net.xenotime.plugin.Plugin
import net.xenotime.plugin.PluginContext

@Plugin(
        "example-plugin",
        "1.0.0",
        "Example Plugin",
        "1.0.0",
        "This is an test Plugin for Xenotime Server Software",
        [
            "eminarican"
        ]
)
class ExamplePlugin : PluginContext() {

}
