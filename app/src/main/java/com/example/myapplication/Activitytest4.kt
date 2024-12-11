package com.example.playlistmaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.myapplication.R

class Activitytest4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4)
//        val backToMainSettings = findViewById<Button>(R.id.button_back)
//        backToMainSettings.setOnClickListener {
//            val backToMainIntent = Intent(this, MainActivity::class.java)
//            startActivity(backToMainIntent)
//        }
        val backToMainSettings = findViewById<ImageView>(R.id.button_back)
        backToMainSettings.setOnClickListener {
            super.finish()
        }
    }
}