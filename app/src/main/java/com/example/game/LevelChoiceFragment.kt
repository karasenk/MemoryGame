package com.example.game

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.core.os.bundleOf
import com.example.game.databinding.FragmentLevelChoiceBinding

class LevelChoiceFragment : Fragment(R.layout.fragment_level_choice) {
    private var viewBinding: FragmentLevelChoiceBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding = FragmentLevelChoiceBinding.bind(view)
        initViews()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    private fun initViews() {
        viewBinding?.apply {
            veryEasyLevelBtn.setOnClickListener {
                toGameFragment(4)
            }
            easyBtn.setOnClickListener {
                toGameFragment(6)
            }
            normalLevelBtn.setOnClickListener {
                toGameFragment(8)
            }
            hardLevelBtn.setOnClickListener {
                toGameFragment(12)
            }
            veryHardLevelBtn.setOnClickListener {
                toGameFragment(16)
            }
        }
    }
    private fun toGameFragment(n: Int){
        val data = bundleOf("level" to n)
        findNavController()
            .navigate(R.id.action_levelChoiceFragment_to_gameFragment, data)
    }
}