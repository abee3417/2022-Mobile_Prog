package com.example.hw8_1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editUserName = findViewById<EditText>(R.id.putUserName)
        var editPassword = findViewById<EditText>(R.id.putPassword)
        var editLogin = findViewById<Button>(R.id.btnLogin)

        val sharedPref = getSharedPreferences("kr.ac.dankook.example.SHARED_PREF", Context.MODE_PRIVATE);
        val editor = sharedPref.edit()

        val username:String? = sharedPref.getString("username", "")
        val password:String? = sharedPref.getString("password", "")
        val id = sharedPref.getInt("id", -1)

        if(id == -1){
            Log.d("yys", "There is no userdata")
        }
        else{
            editUserName.setText(username)
            editPassword.setText(password)
            Log.d("yys", "Reading stored data")
        }

        editLogin.setOnClickListener {
            editor.putString("username", editUserName.text.toString())
            editor.putString("password", editPassword.text.toString())
            editor.putInt("id", 1234)
            editor.apply()
            Log.d("yys", "Saving data")
        }
    }
}