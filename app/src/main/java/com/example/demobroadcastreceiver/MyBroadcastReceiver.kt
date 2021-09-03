package com.example.demobroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    companion object {
        const val STATE = "STATE"
        const val TIME_ZONE = "TIME_ZONE"
        const val POWER = "POWER"
        const val TAG = "MyBroadcastReceiver"
    }

    override fun onReceive(context: Context, intent: Intent) {

        showToast(context, intent.action.toString())
//        val timeZone = intent.getStringExtra(TIME_ZONE)
//        Log.d(TAG, "onReceive $timeZone")
//
//        val isAirplaneModeAvailable = intent.getBooleanExtra(STATE, false)
//        if (isAirplaneModeAvailable) {
//            showToast(context, "Airplane mode enabled")
//        } else {
//            showToast(context, "Airplane mode disabled")
//        }

        val isPowerConnected = intent.getBooleanExtra(POWER, false)
        if (isPowerConnected) {
            showToast(context, "Power connected")
        } else {
            showToast(context, "Power disconnected")
        }

    }

    private fun showToast(context: Context, text: String) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show()
        Log.d(TAG, text)
    }
}

