package com.example.lab01

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity

class UserActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val btn = findViewById<Button>(R.id.button)
        val editor = findViewById<EditText>(R.id.textEditor)
        val start = findViewById<Button>(R.id.start_btn)
        val stop = findViewById<Button>(R.id.stop_btn)

        btn.setOnClickListener {

            val text = editor.text.toString()
            val intent = Intent(this, HelloActivity::class.java)

            intent.putExtra("text", text)
            startActivity(intent)

        }

        start.setOnClickListener {
            this.onStartServiceBtnClick()
        }

        stop.setOnClickListener {
            this.onStopServiceBtnClick()
        }

    }

    private fun onStartServiceBtnClick() {
        val intent = Intent(this, SimpleService::class.java)
        startService(intent)
    }
    private fun onStopServiceBtnClick() {
        val intent = Intent(this, SimpleService::class.java)
        stopService(intent)
    }

}
