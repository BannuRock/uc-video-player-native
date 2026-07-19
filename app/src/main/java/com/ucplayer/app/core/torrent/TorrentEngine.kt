package com.ucplayer.app.core.torrent

import com.frostwire.jlibtorrent.SessionManager
import com.frostwire.jlibtorrent.SessionParams
import com.frostwire.jlibtorrent.SettingsPack
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TorrentEngine @Inject constructor() {
    val sessionManager = SessionManager()

    init {
        val settings = SettingsPack()
        // Enable DHT for trackerless peer resolution
        settings.setEnableDht(true)

        // Set unlimited download/upload rates
        settings.downloadRateLimit(0)
        settings.uploadRateLimit(0)
        
        // Maximize active downloads and seeds limit
        settings.activeDownloads(15)
        settings.activeSeeds(10)
        settings.connectionsLimit(300)
        
        // Configure settings pack for immediate DHT routing bootstrap and dynamic port binding
        settings.swig().set_str(
            com.frostwire.jlibtorrent.swig.settings_pack.string_types.dht_bootstrap_nodes.swigValue(),
            "router.bittorrent.com:6881,router.utorrent.com:6881,dht.transmissionbt.com:6881"
        )
        settings.swig().set_str(
            com.frostwire.jlibtorrent.swig.settings_pack.string_types.listen_interfaces.swigValue(),
            "0.0.0.0:0,[::]:0"
        )

        // Tune SWIG parameters for high-speed sequential streaming
        val swigSettings = settings.swig()
        swigSettings.set_bool(com.frostwire.jlibtorrent.swig.settings_pack.bool_types.smooth_connects.swigValue(), false)
        swigSettings.set_int(com.frostwire.jlibtorrent.swig.settings_pack.int_types.connection_speed.swigValue(), 250)
        swigSettings.set_int(com.frostwire.jlibtorrent.swig.settings_pack.int_types.torrent_connect_boost.swigValue(), 100)
        swigSettings.set_int(com.frostwire.jlibtorrent.swig.settings_pack.int_types.peer_connect_timeout.swigValue(), 5)
        swigSettings.set_int(com.frostwire.jlibtorrent.swig.settings_pack.int_types.request_timeout.swigValue(), 10)
        swigSettings.set_int(com.frostwire.jlibtorrent.swig.settings_pack.int_types.piece_timeout.swigValue(), 10)
        swigSettings.set_int(com.frostwire.jlibtorrent.swig.settings_pack.int_types.max_peerlist_size.swigValue(), 500)
        
        // Start session manager and bootstrap DHT
        sessionManager.start(SessionParams(settings))
        sessionManager.startDht()
    }

    fun stop() {
        if (sessionManager.isRunning) {
            sessionManager.stop()
        }
    }
}
