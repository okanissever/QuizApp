package com.example.quizapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.quizapp.R
import com.example.quizapp.adapter.WordAdapter
import com.example.quizapp.common.viewBinding
import com.example.quizapp.databinding.FragmentWordBinding
import com.example.quizapp.viewmodel.QuestionViewModel


class WordFragment : Fragment(R.layout.fragment_word) {
    private val binding by viewBinding(FragmentWordBinding::bind)
    private val viewModel: QuestionViewModel by viewModels()
    private lateinit var adapter : WordAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAll()
        observeLiveData()

        adapter = WordAdapter(viewModel)

    }

    private fun observeLiveData(){
        viewModel.wordList.observe(viewLifecycleOwner){list->
            list?.let {
                adapter.submitList(it)
                binding.rvWord.adapter = adapter
            }
        }
    }

}