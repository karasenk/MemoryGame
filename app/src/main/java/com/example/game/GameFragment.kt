package com.example.game

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.game.databinding.FragmentGameBinding
import com.example.game.databinding.FragmentMenuBinding
import kotlin.system.exitProcess

class GameFragment : Fragment(R.layout.fragment_game) {
    private var viewBinding: FragmentGameBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentGameBinding.bind(view)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun initViews() {
        viewBinding?.apply {
            greed.setOnItemClickListener(itemListener)
        }
    }
    var itemListener: OnItemClickListener = object : OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            // логика нажатия на карточку
        }
    }
}