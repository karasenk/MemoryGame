package com.example.game

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.example.game.databinding.FragmentMenuBinding
import kotlin.system.exitProcess

class MenuFragment : Fragment(R.layout.fragment_menu) {
    private var viewBinding: FragmentMenuBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentMenuBinding.bind(view)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun initViews() {
        viewBinding?.apply {
            startBtn.setOnClickListener {
                findNavController()
                    .navigate(R.id.action_menuFragment_to_levelChoiceFragment)
            }
            quitBtn.setOnClickListener {
                exitProcess(0)
            }
        }
    }
}