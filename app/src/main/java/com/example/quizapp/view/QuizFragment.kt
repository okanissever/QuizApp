package com.example.quizapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizapp.R
import com.example.quizapp.common.viewBinding
import com.example.quizapp.databinding.FragmentQuizBinding
import com.example.quizapp.viewmodel.QuestionViewModel
import kotlinx.coroutines.CoroutineScope


class QuizFragment : Fragment(R.layout.fragment_quiz) {
    private val binding by viewBinding(FragmentQuizBinding::bind)
    private val args : QuizFragmentArgs by navArgs()
    val viewModel : QuestionViewModel by viewModels()

    var dogru = 0
    var yanlis = 0

    private var currentQuestionIndex = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        showQuestion()

        binding.nextButton.setOnClickListener{
            resetButtonColors()
            currentQuestionIndex++
            println(currentQuestionIndex)
            showQuestion()
        }

    }


    private fun showQuestion(){
        val questionList = args.question


        if (currentQuestionIndex < questionList.size) {
            val currentQuestion = questionList[currentQuestionIndex]
            binding.apply {
                word.text = currentQuestion.question
                buttonA.text = currentQuestion.option1
                buttonB.text = currentQuestion.option2
                buttonC.text = currentQuestion.option3
                buttonD.text = currentQuestion.option4
                val ans = currentQuestion.ans

                val buttons = listOf(buttonA, buttonB, buttonC, buttonD)

                for(button in buttons){
                    button.setOnClickListener {
                        if(button.text == ans){
                            button.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.green))
                            dogru++
                        } else {
                            button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
                            buttons.firstOrNull { it.text == ans }?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
                            viewModel.addWord(currentQuestion)
                            yanlis++
                        }
                    }
                }
            }
        }
        else{
            val action = QuizFragmentDirections.actionQuizFragmentToResultFragment(dogru, yanlis)
            findNavController().navigate(action)
        }
    }


    private fun resetButtonColors() {
        binding.apply {
            val defaultColor = ContextCompat.getColor(requireContext(), R.color.default_button_color)
            buttonA.setBackgroundColor(defaultColor)
            buttonB.setBackgroundColor(defaultColor)
            buttonC.setBackgroundColor(defaultColor)
            buttonD.setBackgroundColor(defaultColor)
        }
    }
}
