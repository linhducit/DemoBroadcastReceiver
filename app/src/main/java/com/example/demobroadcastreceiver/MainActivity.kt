package com.example.demobroadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val broadcast = MyBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filter=IntentFilter()

        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        filter.addAction(Intent.ACTION_APPLICATION_PREFERENCES)
        filter.addAction(Intent.ACTION_POWER_CONNECTED)
        filter.addAction(Intent.ACTION_ATTACH_DATA)
        registerReceiver(broadcast, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcast)
    }
}