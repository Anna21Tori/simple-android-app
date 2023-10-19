package com.example.lab01

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.room.Room
import com.example.lab01.DAO.AppDatabase

class UserActivity : ComponentActivity() {

    private val USER_NAME_EXTRA = "USER_NAME_EXTRA";
    private val NUMBER_RECEIVER_ACTION = "NUMBER_RECEIVER_ACTION"
    private val numberReceiver = NumberReceiver()
    private val filter = IntentFilter(NUMBER_RECEIVER_ACTION)
    private var name = ""

//    private val db = Room.databaseBuilder(
//        applicationContext,
//        AppDatabase::class.java, "users.db"
//    ).build()
    public override fun onResume() {
        super.onResume()
        registerReceiver(numberReceiver, filter)
    }
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(numberReceiver)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity)

        val start = findViewById<Button>(R.id.start_btn)
        val stop = findViewById<Button>(R.id.stop_btn)
        val read = findViewById<Button>(R.id.read_btn)
        val db = AppDatabase.getInstance(this)

        this.name = intent.getStringExtra("text").toString()
        val textView = findViewById<TextView>(R.id.textView)

        textView.text = "Hello ".plus(this.name)

        start.setOnClickListener {
            this.onStartServiceBtnClick()
        }

        stop.setOnClickListener {
            this.onStopServiceBtnClick()
        }

        read.setOnClickListener {
            val counter = db?.userDao()?.getAll()?.size
            Log.d("Counter db", counter.toString())
        }
    }

    private fun onStartServiceBtnClick() {
        val intent = Intent(this, SimpleService::class.java)
        intent.putExtra(USER_NAME_EXTRA, this.name)
        startService(intent)
    }
    private fun onStopServiceBtnClick() {
        val intent = Intent(this, SimpleService::class.java)
        stopService(intent)
    }
}