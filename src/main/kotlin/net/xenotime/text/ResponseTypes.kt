package net.xenotime.text

enum class ResponseTypes(prefix: String) {
    INFO("?"),
    WARN("!"),
    ERROR("-"),
    SYSTEM("#"),
    SUCCESS("+")
}
