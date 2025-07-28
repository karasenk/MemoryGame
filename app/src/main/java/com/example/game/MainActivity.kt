package com.example.game

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null // Переменная для управления музыкой

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun startNewActivity(view: View) {
        startActivity(Intent(this, DifficultySelectionActivity::class.java))
    }

    fun exitApp(view: View) {
        finishAffinity()
    }

    fun onPlayMusicClick(view: View) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(this, R.raw.background_music_new)
            mediaPlayer?.isLooping = true
        }
        mediaPlayer?.start()
    }

    fun onStopMusicClick(view: View) {
        mediaPlayer?.pause()
        mediaPlayer?.seekTo(0) // Сброс на начало
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
