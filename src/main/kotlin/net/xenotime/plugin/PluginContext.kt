package net.xenotime.plugin

abstract class PluginContext {

    open fun onPreInitialize() {}
    open fun onDeInitialize() {}
    open fun onInitialize() {}
}
