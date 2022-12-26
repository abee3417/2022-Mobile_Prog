package com.example.hw7_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0
        var textView = findViewById<TextView>(R.id.textview)
        var rwBtn = findViewById<Button>(R.id.rw_btn)
        val fileName = "internal.txt"
        val fileReading = "New number written to file"


        rwBtn.setOnClickListener {
            val fileReadNum = "File for testing ${count/2}"
            applicationContext.openFileOutput(fileName, Context.MODE_PRIVATE).use {
                if(count%2==0) {
                    it.write(fileReading.toByteArray())
                    rwBtn.setText("READ")
                }
                else {
                    it.write(fileReadNum.toByteArray())
                    rwBtn.setText("WRITE")
                }
                it.close()
            }
            applicationContext.openFileInput(fileName).use {
                var txt = it.bufferedReader().readLine()
                textView.setText(txt.toString())
                it.close()
            }
            count++
        }


    }
}