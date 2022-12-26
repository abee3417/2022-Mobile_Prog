package com.example.hw6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val intentSub = intent
        val num1 = intentSub.getIntExtra("num1", 0)
        val num2 = intentSub.getIntExtra("num2", 0)
        val backBtn = findViewById<Button>(R.id.backBtn)
        backBtn.setOnClickListener {
            Log.d("DKMobile", "BACK button pressed.")
            finish()
        }

        val result = findViewById<TextView>(R.id.sumnumber)
        result.setText(num1.toString() + " + " + num2.toString() + " = " + (num1 + num2).toString())
    }
}