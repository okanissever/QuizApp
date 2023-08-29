package com.example.quizapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizapp.R
import com.example.quizapp.common.viewBinding
import com.example.quizapp.databinding.FragmentResultBinding
import com.example.quizapp.databinding.FragmentWordBinding


class ResultFragment : Fragment(R.layout.fragment_result) {
    private val binding by viewBinding(FragmentResultBinding::bind)
    private val args : ResultFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.let {
            binding.dogruSayisi.text = it.dogru.toString()
            binding.yanlisSayisi.text = it.yanlis.toString()
        }

        binding.nextButton.setOnClickListener {
            val action = ResultFragmentDirections.actionResultFragmentToHomeFragment()
            findNavController().navigate(action)
        }

    }

}