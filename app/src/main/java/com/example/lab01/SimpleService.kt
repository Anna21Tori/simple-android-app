package com.example.lab01

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SimpleService : Service() {

    private var isDestroyed = false

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        performTask()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        this.isDestroyed = true
    }

    private fun performTask(){
        GlobalScope.launch {
            var number = 0
            while (!isDestroyed) {
                number++
                Log.d("TAG","New number $number")
                delay(1000)
            }
        }
    }
}