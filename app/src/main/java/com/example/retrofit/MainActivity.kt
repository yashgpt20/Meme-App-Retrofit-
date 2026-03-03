package com.example.retrofit

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val x = Intent(this@MainActivity, Meme::class.java)
            startActivity(x)
            finish()
        },2100)

    }
}