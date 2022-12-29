package com.example.final_32192530

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val resultTxt = findViewById<TextView>(R.id.idresultTxt)
        val printUsername = findViewById<TextView>(R.id.idchecknameTxt)
        val printPassword = findViewById<TextView>(R.id.idcheckpwTxt)
        val returnBtn = findViewById<Button>(R.id.idreturnBtn
        )
        val intentSub = intent
        val outputName = intentSub.getStringExtra("username")
        val outputPW = intentSub.getStringExtra("password")
        val outputCase = intentSub.getIntExtra("case", -1)

        printUsername.setText(outputName)
        printPassword.setText(outputPW)

        if (outputCase == 1){
            resultTxt.setText("New user logged in")
        }
        else if (outputCase == 2){
            resultTxt.setText("Invalid username")
        }
        else if (outputCase == 3){
            resultTxt.setText("Invalid password")
        }
        else if (outputCase == 4){
            resultTxt.setText("User successfully logged in")
        }

        returnBtn.setOnClickListener {
            setResult(Activity.RESULT_OK, intentSub)
            finish()
        }
    }
}