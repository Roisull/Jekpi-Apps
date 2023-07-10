package com.isulin.jekpi.view.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class BaseApplication: Application() {
    companion object{
        const val CHANNEL_1_ID = "Channel1"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannelIs()
    }
    private fun createNotificationChannelIs(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1){
            val channel1 = NotificationChannel(
                CHANNEL_1_ID,
                "Channel Satu",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "ini adalah channel 1"

            val manager: NotificationManager? = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel1)
        }
    }
}