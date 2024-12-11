package com.example.playlistmaker

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ActivityMedia :  AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)
        val backToMainSettings = findViewById<ImageView>(R.id.button_back)
        backToMainSettings.setOnClickListener {
            super.finish()
        }
    }
}