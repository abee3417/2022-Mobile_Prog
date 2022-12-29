package com.example.hw8_2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var count : Int = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
            applicationContext,
            UserDB::class.java, "userdb"
        ).allowMainThreadQueries().build()

        var editUserName = findViewById<EditText>(R.id.putUserName)
        var editPassword = findViewById<EditText>(R.id.putPassword)
        var editLogin = findViewById<Button>(R.id.btnLogin)
        val users = db.userDao().getAll()

        editLogin.setOnClickListener {
            val userd = User(count++, editUserName.text.toString(), editPassword.text.toString())
            db.userDao().insertAll(userd)
            var readuser = db.userDao().findByName(editUserName.text.toString(), editPassword.text.toString())
            if (readuser != null){
                Log.d("USERDB", readuser.user_name+" "+readuser.pass_word)
            }
        }
    }
}