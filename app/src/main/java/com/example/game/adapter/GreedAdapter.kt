package com.example.game.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.game.model.CardModel

class GreedAdapter(
    private val data: List<CardModel>
) : BaseAdapter(){
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any? {
        return data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup?
    ): View? {
        TODO("Not yet implemented")
    }

}