package com.example.inclasscoroutineactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    lateinit var countDown: TextView
    lateinit var startButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countDown = findViewById(R.id.countDown)
        startButton = findViewById(R.id.startButton)

        startButton.setOnClickListener{
            startCountdown()
        }
    }

        private fun startCountdown() {
            CoroutineScope(Job() + Dispatchers.Main).launch {
                for (i in 100 downTo 0) {
                    countDown.text = i.toString()
                    delay(1000)
                }
            }
        }
}