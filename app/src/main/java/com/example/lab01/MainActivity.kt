package com.example.lab01

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val btn = findViewById<Button>(R.id.button)
        val editor = findViewById<EditText>(R.id.textEditor)

        btn.setOnClickListener {

            val text = editor.text.toString()
            val intent = Intent(this, UserActivity::class.java)

            intent.putExtra("text", text)
            startActivity(intent)

        }


    }


}
