package com.example.lab01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class NumberReceiver : BroadcastReceiver() {
    val NUMBER_EXTRA = "NUMBER_EXTRA"
    val USER_NAME_EXTRA = "USER_NAME_EXTRA"
    override fun onReceive(context: Context, intent: Intent) {

        val number = intent.getIntExtra(NUMBER_EXTRA, 0)
        val user = intent.getStringExtra(USER_NAME_EXTRA)

        Log.d("Received user name: ", user!!)
        Log.d("Received number: ", "" + number)

    }
}