package com.example.lab01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class NumberReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        Log.d("NumberReceiver", "Received message")
        val number = intent.getIntExtra(NUMBER_EXTRA, 0) ?: 0
        val user = intent.getStringExtra(USER_NAME_EXTRA) ?: ""

    }
}