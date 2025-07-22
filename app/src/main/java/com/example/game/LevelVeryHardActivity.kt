package com.example.game

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LevelVeryHardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_level_very_hard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun menu(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun end(view: View) {
        startActivity(Intent(this, MenuActivity::class.java))
    }

    fun pause(view: View) {
        val imageView = findViewById<ImageView>(R.id.myImage)
        imageView.visibility = if (imageView.visibility == View.VISIBLE) View.GONE else View.VISIBLE
        imageView.setImageResource(R.drawable.pause_picture)
    }
}