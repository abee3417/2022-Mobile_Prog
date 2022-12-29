package com.example.final_32192530

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private val getResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val loginName = findViewById<EditText>(R.id.idnameTxt)
            val loginPW = findViewById<EditText>(R.id.idpwTxt)
            loginName.setText("")
            loginPW.setText("")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref =
            getSharedPreferences("kr.ac.dankok.example.SHARED_PREF", Context.MODE_PRIVATE);
        val loginName = findViewById<EditText>(R.id.idnameTxt)
        val loginPW = findViewById<EditText>(R.id.idpwTxt)
        val loginBtn = findViewById<Button>(R.id.idloginBtn)

        loginBtn.setOnClickListener {
            val inputName = loginName.getText().toString()
            val inputPW = loginPW.getText().toString()
            val testName = sharedPref.getString("name", "No name")
            val testPW = sharedPref.getString("pw", "No PW")
            val testID = sharedPref.getString("id", "-1")
            val editor = sharedPref.edit()
            val intentMain = Intent(this, SubActivity::class.java)

            intentMain.putExtra("username", inputName)
            intentMain.putExtra("password", inputPW)

            if (testID.toString().toInt() == -1) { // case1
                editor.putString("name", inputName)
                editor.putString("pw", inputPW)
                editor.putString("id", "1")
                editor.apply()
                intentMain.putExtra("case", 1)
            } else if (testID == "1" && !inputName.equals(testName)) { // case2
                intentMain.putExtra("case", 2)
            } else if (testID == "1" && !inputPW.equals(testPW)) { // case3
                intentMain.putExtra("case", 3)
            } else { // case4
                intentMain.putExtra("case", 4)
            }
            getResult.launch(intentMain)
        }
    }
}
