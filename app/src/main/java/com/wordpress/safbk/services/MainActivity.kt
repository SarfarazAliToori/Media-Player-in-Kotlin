package com.wordpress.safbk.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var startButton: Button
    lateinit var stopButton: Button
    lateinit var myForegroundService: Button
    lateinit var myStopForegroundService: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myInit()
    }

    private fun myInit() {
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)
        myForegroundService = findViewById(R.id.start_foreground_service)
        myStopForegroundService = findViewById(R.id.stop_foreground_service)

        startButton.setOnClickListener(this)
        stopButton.setOnClickListener(this)
        myForegroundService.setOnClickListener(this)
        myStopForegroundService.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

        if (p0 == startButton)
            startService(Intent(this, NewService::class.java))
        else if (p0 == stopButton)
            stopService(Intent(this, NewService::class.java))

        if (p0 == myForegroundService){
            ContextCompat.startForegroundService(this, Intent(this, ForegroundService::class.java))
        } else if (p0 == myStopForegroundService) {
            stopService(Intent(this, ForegroundService::class.java))
        }
    }

}