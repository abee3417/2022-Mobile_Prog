package com.example.midterm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var to = findViewById<TextView>(R.id.email)
        var subject = findViewById<TextView>(R.id.sbj)
        var message = findViewById<TextView>(R.id.msg)
        var sendbtn = findViewById<Button>(R.id.send)

        sendbtn.setOnClickListener {
            val first : String = to.getText().toString()
            val second : String = subject.getText().toString()
            val third : String = message.getText().toString()
            val result : String = "To : ${first} Subject : ${second} Message : ${third}"
            message.setText(result)

        }
    }
}