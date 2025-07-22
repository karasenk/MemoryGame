package com.example.game

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun veryEasyLevel(view: View) {
        startActivity(Intent(this, MainActivity3::class.java))
    }

    fun easyLevel(view: View) {
        startActivity(Intent(this, MainActivity4::class.java))
    }

    fun normalLevel(view: View) {
        startActivity(Intent(this, MainActivity5::class.java))
    }

    fun hardLevel(view: View) {
        startActivity(Intent(this, MainActivity5::class.java))
    }

    fun veryHardLevel(view: View) {
        startActivity(Intent(this, MainActivity5::class.java))
    }

}