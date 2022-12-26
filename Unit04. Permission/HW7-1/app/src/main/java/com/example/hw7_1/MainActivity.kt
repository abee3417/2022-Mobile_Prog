package com.example.hw7_1

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dangerTv = findViewById<TextView>(R.id.danger_tv)
        var cameraBtn = findViewById<Button>(R.id.camera_btn)

        cameraBtn.setOnClickListener {
            Log.d("DKMobile", "CAMERA button pressed")
            val cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)

            if(cameraPermission == PackageManager.PERMISSION_GRANTED) {
                Log.d("DKMOBILE", "CAMERA permission already granted")
                dangerTv.setText("Permission already granted")
            }
            else {
                ActivityCompat.requestPermissions(this,arrayOf(Manifest.permission.CAMERA), 99)
            }
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var dangerTv = findViewById<TextView>(R.id.danger_tv)

        when(requestCode) {
            99 -> {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.d("DKMOBILE", "CAMERA permission granted now")
                    dangerTv.setText("CAMERA permission granted now")
                }
                else {
                    Log.d("DKMOBILE", "CAMERA permission not granted")
                    dangerTv.setText("CAMERA permission not granted")
                }
            }
        }
    }
}