package com.example.game

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LevelNormalActivity : AppCompatActivity() {
    // Парные изображения (6 пар)
    private val cardImages = listOf(
        R.drawable.axolotl_open_button,
        R.drawable.axolotl_open_button,
        R.drawable.crab_open_button,
        R.drawable.crab_open_button,
        R.drawable.fish_open_button,
        R.drawable.fish_open_button,
        R.drawable.pufferfish_open_button,
        R.drawable.pufferfish_open_button
    ).shuffled()

    private var startTime: Long = 0
    private var elapsedTime: Long = 0
    private lateinit var timerHandler: Handler
    private val timerRunnable = object : Runnable {
        override fun run() {
            val currentTime = SystemClock.elapsedRealtime() - startTime
            timerHandler.postDelayed(this, 1000)
        }
    }
    private val cardBack = R.drawable.secret_button_game
    private var flippedCards = mutableListOf<ImageButton>()
    private var matchedPairs = 0
    private var isChecking = false

    private var movesCount = 0
    private lateinit var prefs: SharedPreferences
    private val PREFS_NAME = "GamePrefs"
    private val BEST_SCORE_KEY = "best_score_normal"

    private var pauseOffset: Long = 0

    private var isTimerRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_normal)

        prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        timerHandler = Handler(Looper.getMainLooper())

        val buttons = listOf(
            findViewById<ImageButton>(R.id.card_1),
            findViewById<ImageButton>(R.id.card_2),
            findViewById<ImageButton>(R.id.card_3),
            findViewById<ImageButton>(R.id.card_4),
            findViewById<ImageButton>(R.id.card_5),
            findViewById<ImageButton>(R.id.card_6),
            findViewById<ImageButton>(R.id.card_7),
            findViewById<ImageButton>(R.id.card_8)
        )

        buttons.forEachIndexed { index, button ->
            button.setImageResource(cardBack)
            button.tag = null
            button.setOnClickListener {
                if (!isChecking && button.tag == null && flippedCards.size < 2) {
                    flipCard(button, index)
                }
            }
        }
        startTimer()
    }

    private val TOTAL_PAIRS = 4 // Добавляем константу

    private fun checkForMatch() {
        if (flippedCards[0].tag == flippedCards[1].tag) {
            flippedCards.forEach { it.isEnabled = false }
            matchedPairs++
            if (matchedPairs == TOTAL_PAIRS) gameCompleted() // Исправлено на TOTAL_PAIRS
            flippedCards.clear()
            isChecking = false
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                flippedCards.forEach {
                    it.setImageResource(cardBack)
                    it.tag = null
                }
                flippedCards.clear()
                isChecking = false
            }, 1000)
        }
    }

    override fun onResume() {
        super.onResume()
        if (matchedPairs < TOTAL_PAIRS) { // Исправлено на TOTAL_PAIRS
            startTimer()
        }
    }

    private fun flipCard(button: ImageButton, index: Int) {
        button.setImageResource(cardImages[index])
        flippedCards.add(button)
        button.tag = cardImages[index]

        movesCount++ // Увеличиваем счётчик ходов

        if (flippedCards.size == 2) {
            isChecking = true
            checkForMatch()
        }
    }

    private fun startTimer() {
        startTime = SystemClock.elapsedRealtime() - pauseOffset
        timerHandler.postDelayed(timerRunnable, 1000)
        isTimerRunning = true
    }

    private fun stopTimer() {
        timerHandler.removeCallbacks(timerRunnable)
        elapsedTime = SystemClock.elapsedRealtime() - startTime
        isTimerRunning = false
    }

    private fun gameCompleted() {
        stopTimer()

        val bestScore = prefs.getInt(BEST_SCORE_KEY, Int.MAX_VALUE)
        val isNewRecord = movesCount < bestScore
        val isFirstRecord = bestScore == Int.MAX_VALUE

        if (isNewRecord) {
            prefs.edit().putInt(BEST_SCORE_KEY, movesCount).apply()
        }

        val intent = Intent(this, LevelResultActivity::class.java).apply {
            putExtra("MOVES_COUNT", movesCount)
            putExtra("PREVIOUS_SCORE", bestScore)
            putExtra("IS_NEW_RECORD", isNewRecord)
            putExtra("IS_FIRST_RECORD", isFirstRecord) // Добавляем флаг первого рекорда
            putExtra("LEVEL_NAME", "Нормально") // Для каждого уровня свое имя
            putExtra("ELAPSED_TIME", elapsedTime)
        }
        startActivity(intent)
        finish()
    }

    override fun onPause() {
        super.onPause()
        stopTimer()
    }

    fun menu(view: View) = startActivity(Intent(this, MainActivity::class.java))

    fun pause(view: View) {
        val pauseOverlay = findViewById<ImageView>(R.id.pauseOverlay)
        val isCurrentlyPaused = pauseOverlay.visibility == View.VISIBLE

        if (isCurrentlyPaused) {
            // Если игра была на паузе - возобновляем
            startTime = SystemClock.elapsedRealtime() - pauseOffset
            startTimer()

            // Разблокируем карточки (только если игра не завершена)
            if (matchedPairs < TOTAL_PAIRS) {
                listOf(R.id.card_1, R.id.card_2, R.id.card_3, R.id.card_4).forEach { id ->
                    findViewById<ImageButton>(id).isClickable = true
                }
            }

            pauseOverlay.visibility = View.GONE
        } else {
            // Если игра не на паузе - ставим на паузу
            stopTimer()
            pauseOffset = elapsedTime

            // Блокируем карточки
            listOf(R.id.card_1, R.id.card_2, R.id.card_3, R.id.card_4).forEach { id ->
                findViewById<ImageButton>(id).isClickable = false
            }

            pauseOverlay.visibility = View.VISIBLE
        }
    }
}