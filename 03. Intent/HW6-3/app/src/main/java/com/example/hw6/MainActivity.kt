package com.example.hw6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result->
            if(result.resultCode == Activity.RESULT_OK){
                val value = result.data?.getIntExtra("sumresult", 0)
                Log.d("DKMobile", "Received Result is " + value.toString())
                val mainResultView = findViewById<TextView>(R.id.mainResultView)
                mainResultView.text = "Result is " + value.toString()
            }
        }

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
            getResult.launch(intentMain)
        }
    }

    override fun onStart(){
        super.onStart()
        Log.d("DKMobile", "MainActivity onStart()")
    }

    override fun onResume(){
        super.onResume()
        Log.d("DKMobile", "MainActivity onResume()")
    }

    override fun onPause(){
        super.onPause()
        Log.d("DKMobile", "MainActivity onPause()")
    }

    override fun onStop(){
        super.onStop()
        Log.d("DKMobile", "MainActivity onStop()")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("DKMobile", "MainActivity onDestroy()")
    }
}

