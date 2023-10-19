package com.example.lab01

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class HelloActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity)

        val text: String = intent.getStringExtra("text").toString()
        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Hello ".plus(text)

    }
}