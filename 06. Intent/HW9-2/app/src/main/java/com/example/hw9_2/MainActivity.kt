package com.example.hw9_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout. activity_main)
        val start = findViewById<Button>(R.id.startBtn)
        val stop = findViewById<Button>(R.id.stopBtn)
        val helloText = findViewById<TextView>(R.id.helloText)
        var min = 0
        var sec = 0
        var printMin : String
        var printSec : String
        var mode : Boolean = true
        start.setOnClickListener{
            mode = true
            min = 0
            sec = 0
            val myHandler = object : Handler(Looper.getMainLooper()) {
                override fun handleMessage(msg: Message) {
                    super.handleMessage(msg)
                    Log.d("BkgThread", "Main thread")
                    if(msg.what == 1) {
                        if (msg.arg1 < 10){
                            printMin = "0" + msg.arg1.toString()
                        }
                        else{
                            printMin = msg.arg1.toString()
                        }
                        if (msg.arg2 < 10){
                            printSec = "0" + msg.arg2.toString()
                        }
                        else{
                            printSec = msg.arg2.toString()
                        }
                        helloText.setText("${printMin}:${printSec}")
                    }
                }
            }
            Thread {
                while(mode == true) {
                    sec += 1
                    if (sec == 60){
                        sec = 0
                        min += 1
                    }
                    var msg = myHandler.obtainMessage()
                    msg.what = 1
                    msg.arg1 = min
                    msg.arg2 = sec
                    myHandler.sendMessage(msg)
                    Thread.sleep(1000)
                }
            }.start()
        }

        stop.setOnClickListener {
            mode = false
        }
    }
}