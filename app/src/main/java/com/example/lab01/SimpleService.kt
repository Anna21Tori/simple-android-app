package com.example.lab01

import android.R.attr.name
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SimpleService : Service() {

    private val NUMBER_RECEIVER_ACTION = "NUMBER_RECEIVER_ACTION"
    private val NUMBER_EXTRA = "NUMBER_EXTRA"
    private val USER_NAME_EXTRA = "USER_NAME_EXTRA"

    private var isDestroyed = false
    private var number = 0
    private var name = ""

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
          this.name = intent?.getStringExtra(USER_NAME_EXTRA).toString()
//        val newInte nt = Intent(NumberReceiver.NUMBER_RECEIVER_ACTION)
//        newIntent.putExtra(NumberReceiver.NUMBER_EXTRA, number)
//        newIntent.putExtra(NumberReceiver.USER_NAME_EXTRA, intent!!.getStringExtra(HelloActivity.USER_NAME_EXTRA))
//        sendBroadcast(newIntent)

        performTask()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()

        this.sendMessage()
        this.isDestroyed = true
    }

    private fun performTask(){
        val that = this;
        GlobalScope.launch {
            that.number = 0
            while (!isDestroyed) {
                that.number++
                Log.d("TAG","New number ${that.number}")
                delay(1000)
            }
        }
    }

    private fun sendMessage() {
        val newIntent = Intent(NUMBER_RECEIVER_ACTION)
        newIntent.putExtra(NUMBER_EXTRA, this.number)
        newIntent.putExtra(USER_NAME_EXTRA, this.name)
        sendBroadcast(newIntent)
    }
}