package api.server

object ServerHolder {

    private lateinit var reference: Server
    var instance: Server
        set(value) {
            if (!::reference.isInitialized) {
                reference = value
            }
        }
        get() = reference
}
