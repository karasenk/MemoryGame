package com.example.game

import com.example.game.model.CardModel

object Content {
    val IMAGE_PATH_LIST = listOf(
        "res/drawable/axolotl_open_button.png",
        "res/drawable/crayfish_open_button.png",
        "res/drawable/fish_open_button.png",
        "res/drawable/jellyfish_open_button.png",
        "res/drawable/pufferfish_open_button.png",
        "res/drawable/seagrass_open_button.png",
        "res/drawable/seahorse_open_button.png"
    )

    fun getData(): List<CardModel>{
        val data = mutableListOf<CardModel>()
        for (img in IMAGE_PATH_LIST) {
            {
                data.add(CardModel(img, false))
            }
        }
        return data
    }
}