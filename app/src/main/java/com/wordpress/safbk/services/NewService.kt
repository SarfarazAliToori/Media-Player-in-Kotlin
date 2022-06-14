package com.wordpress.safbk.services

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings
import android.util.Log


class NewService : Service(){

    lateinit var player: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        return super.onStartCommand(intent, flags, startId)

        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)

        player.isLooping = true

        player.start()

        Log.i("Hello", "Service is Running....")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Hello", "Service is Stop Now...")
        player.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }


}