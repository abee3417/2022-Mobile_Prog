package com.example.hw6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intentMain = Intent(this, SubActivity::class.java)

        val n1 = findViewById<EditText>(R.id.number1)
        val n2 = findViewById<EditText>(R.id.number2)

        val openSubBtn = findViewById<Button>(R.id.openSubBtn)
        openSubBtn.setOnClickListener {
            intentMain.putExtra("num1", n1.getText().toString().toInt())
            intentMain.putExtra("num2", n2.getText().toString().toInt())
            Log.d("DKMobile", "OPEN SUB button pressed.")
            startActivity(intentMain)
        }
    }
}