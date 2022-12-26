package com.example.hw6

import android.app.Activity
import android.content.Intent
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
        val plusres =  num1.toString().toInt() + num2.toString().toInt()
        val result = findViewById<TextView>(R.id.sumnumber)
        result.setText(num1.toString() + " + " + num2.toString() + " = " + plusres)

        backBtn.setOnClickListener {
            val outIntent = Intent(this,MainActivity::class.java)
            outIntent.putExtra("sumresult", plusres)
            setResult(Activity.RESULT_OK, outIntent)
            Log.d("DKMobile", "BACK button pressed.")

            finish()
        }


    }

    override fun onStart(){
        super.onStart()
        Log.d("DKMobile", "SubActivity onStart()")
    }

    override fun onResume(){
        super.onResume()
        Log.d("DKMobile", "SubActivity onResume()")
    }

    override fun onPause(){
        super.onPause()
        Log.d("DKMobile", "SubActivity onPause()")
    }

    override fun onStop(){
        super.onStop()
        Log.d("DKMobile", "SubActivity onStop()")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d("DKMobile", "SubActivity onDestroy()")
    }
}