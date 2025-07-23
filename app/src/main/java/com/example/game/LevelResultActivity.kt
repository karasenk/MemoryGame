package com.example.game

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LevelResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_result)

        val movesCount = intent.getIntExtra("MOVES_COUNT", 0)
        val previousScore = intent.getIntExtra("PREVIOUS_SCORE", Int.MAX_VALUE)
        val isNewRecord = intent.getBooleanExtra("IS_NEW_RECORD", false)
        val isFirstRecord = intent.getBooleanExtra("IS_FIRST_RECORD", false)
        val levelName = intent.getStringExtra("LEVEL_NAME") ?: ""
        val elapsedTime = intent.getLongExtra("ELAPSED_TIME", 0)

        // Получаем лучший результат для текущего уровня
        val prefs = getSharedPreferences("GamePrefs", MODE_PRIVATE)
        val bestScoreKey = when (levelName) {
            "very_easy" -> "best_score_very_easy"
            "easy" -> "best_score_easy"
            "normal" -> "best_score_normal"
            "hard" -> "best_score_hard"
            "very_hard" -> "best_score_very_hard"
            else -> "ERROR" // fallback
        }
        val actualBestScore = prefs.getInt(bestScoreKey, Int.MAX_VALUE)

        val title = findViewById<TextView>(R.id.title)
        val timeSpent = findViewById<TextView>(R.id.timeSpent)
        val bestTime = findViewById<TextView>(R.id.bestTime)

        title.text = "Уровень ${levelName.replace("_", " ")} пройден!"
        timeSpent.text = "Ходов сделано: $movesCount"

        when {
            isFirstRecord -> {
                bestTime.text = "Новый рекорд: $movesCount ходов"
            }
            isNewRecord -> {
                bestTime.text = "Новый рекорд! Предыдущий: $previousScore ходов"
            }
            else -> {
                bestTime.text = "Ваш результат: $movesCount ходов\nЛучший: $actualBestScore ходов"
            }
        }

        findViewById<TextView>(R.id.elapsedTime).text =
            "Время прохождения: ${formatTime(elapsedTime)}"
    }

    private fun formatTime(millis: Long): String {
        val seconds = (millis / 1000) % 60
        val minutes = (millis / (1000 * 60)) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    fun backToMenu(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}