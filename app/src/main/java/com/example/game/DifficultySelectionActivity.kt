package com.example.game

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
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
        val cardImages = arrayListOf(
            R.drawable.axolotl_open_button,
            R.drawable.axolotl_open_button,
            R.drawable.crab_open_button,
            R.drawable.crab_open_button
        )
        val btnsId = arrayListOf(
            R.id.card_1,
            R.id.card_2,
            R.id.card_3,
            R.id.card_4,
        )
        startGame(cardImages, btnsId, R.layout.activity_level_very_easy, "best_score_very_easy")
    }

    fun easyLevel(view: View) {
        val cardImages = arrayListOf(
            R.drawable.axolotl_open_button,
            R.drawable.axolotl_open_button,
            R.drawable.crab_open_button,
            R.drawable.crab_open_button,
            R.drawable.fish_open_button,
            R.drawable.fish_open_button
        )
        val btnsId = arrayListOf(
            R.id.card_1,
            R.id.card_2,
            R.id.card_3,
            R.id.card_4,
            R.id.card_5,
            R.id.card_6
        )
        startGame(cardImages, btnsId, R.layout.activity_level_easy, "best_score_easy")
    }

    fun normalLevel(view: View) {
        val cardImages = arrayListOf(
            R.drawable.axolotl_open_button,
            R.drawable.axolotl_open_button,
            R.drawable.crab_open_button,
            R.drawable.crab_open_button,
            R.drawable.fish_open_button,
            R.drawable.fish_open_button,
            R.drawable.pufferfish_open_button,
            R.drawable.pufferfish_open_button
        )
        val btnsId = arrayListOf(
            R.id.card_1,
            R.id.card_2,
            R.id.card_3,
            R.id.card_4,
            R.id.card_5,
            R.id.card_6,
            R.id.card_7,
            R.id.card_8
        )
        startGame(cardImages, btnsId, R.layout.activity_level_normal, "best_score_normal")
    }

    fun hardLevel(view: View) {
        val cardImages = arrayListOf(
            R.drawable.axolotl_open_button,
            R.drawable.axolotl_open_button,
            R.drawable.crab_open_button,
            R.drawable.crab_open_button,
            R.drawable.fish_open_button,
            R.drawable.fish_open_button,
            R.drawable.pufferfish_open_button,
            R.drawable.pufferfish_open_button,
            R.drawable.jellyfish_open_button,
            R.drawable.jellyfish_open_button,
            R.drawable.seahorse_open_button,
            R.drawable.seahorse_open_button
        )
        val btnsId = arrayListOf(
            R.id.card_1,
            R.id.card_2,
            R.id.card_3,
            R.id.card_4,
            R.id.card_5,
            R.id.card_6,
            R.id.card_7,
            R.id.card_8,
            R.id.card_9,
            R.id.card_10,
            R.id.card_11,
            R.id.card_12
        )
        startGame(cardImages, btnsId, R.layout.activity_level_hard, "best_score_hard")
    }

    fun veryHardLevel(view: View) {
        val cardImages = arrayListOf(
            R.drawable.axolotl_open_button,
            R.drawable.axolotl_open_button,
            R.drawable.crab_open_button,
            R.drawable.crab_open_button,
            R.drawable.fish_open_button,
            R.drawable.fish_open_button,
            R.drawable.pufferfish_open_button,
            R.drawable.pufferfish_open_button,
            R.drawable.jellyfish_open_button,
            R.drawable.jellyfish_open_button,
            R.drawable.seahorse_open_button,
            R.drawable.seahorse_open_button,
            R.drawable.shell_open_button,
            R.drawable.shell_open_button,
            R.drawable.sea_grass_open_button,
            R.drawable.sea_grass_open_button
        )
        val btnsId = arrayListOf(
            R.id.card_1,
            R.id.card_2,
            R.id.card_3,
            R.id.card_4,
            R.id.card_5,
            R.id.card_6,
            R.id.card_7,
            R.id.card_8,
            R.id.card_9,
            R.id.card_10,
            R.id.card_11,
            R.id.card_12,
            R.id.card_13,
            R.id.card_14,
            R.id.card_15,
            R.id.card_16
        )
        startGame(cardImages, btnsId, R.layout.activity_level_very_hard, "best_score_very_hard")
    }

    fun startGame(cardImages: ArrayList<Int>, btnsId: ArrayList<Int>, viewId: Int, BEST_SCORE_KEY: String){
        val data = bundleOf(
            "cardImages" to cardImages,
            "btnsId" to btnsId,
            "viewId" to viewId,
            "BEST_SCORE_KEY" to BEST_SCORE_KEY
        )
        val intent = Intent(this, GameActivity::class.java).apply{
            putExtra("data", data)
        }
        startActivity(intent)
    }

}