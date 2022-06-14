package com.wordpress.safbk.services

import android.app.*
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat

class ForegroundService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this,0, notificationIntent,PendingIntent.FLAG_IMMUTABLE)

        val CHANNEL_ID = "hello World"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel  = NotificationChannel(CHANNEL_ID, "hello",NotificationManager.IMPORTANCE_DEFAULT)
            getSystemService(NotificationManager::class.java).createNotificationChannel(notificationChannel)
        }

        val notification = NotificationCompat.Builder(this,CHANNEL_ID)
            .setContentTitle("Hello Notification")
            .setContentText("Foreground Service is running...")
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()

        startForeground(1, notification)

        Log.i("Hello", "Foreground Service is Running...")

        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Hello", "Foreground Service is stop now...")
        stopForeground(true)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

}
