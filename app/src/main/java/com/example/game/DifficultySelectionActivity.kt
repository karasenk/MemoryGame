package com.example.game

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DifficultySelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_difficulty_selection)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun veryEasyLevel(view: View) {
        startActivity(Intent(this, LevelVeryEasyActivity::class.java))
    }

    fun easyLevel(view: View) {
        startActivity(Intent(this, LevelEasyActivity::class.java))
    }

    fun normalLevel(view: View) {
        startActivity(Intent(this, LevelNormalActivity::class.java))
    }

    fun hardLevel(view: View) {
        startActivity(Intent(this, LevelHardActivity::class.java))
    }

    fun veryHardLevel(view: View) {
        startActivity(Intent(this, LevelVeryHardActivity::class.java))
    }

}