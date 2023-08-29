package com.example.quizapp.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.quizapp.R
import com.example.quizapp.adapter.QuestionAdapter
import com.example.quizapp.common.viewBinding
import com.example.quizapp.databinding.FragmentQuestionBinding
import com.example.quizapp.model.Question
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class QuestionFragment : Fragment(R.layout.fragment_question) {
    private val binding by viewBinding(FragmentQuestionBinding::bind)
    private val args : QuestionFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = QuestionAdapter{position->
            Log.d("QuestionFragment", "Item at position $position was clicked.")
            val questionNumber = "question${position + 1}"
            loadQuestions(args.level,questionNumber)
        }

        binding.rvQuestion.adapter = adapter

    }

    private fun loadQuestions(level : String, questionNumber: String){
        val db = Firebase.firestore
        val questionList = mutableListOf<Question>()

        db.collection("Questions").document(level).collection(questionNumber).get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents) {
                    val question = document.toObject(Question::class.java)
                    if (question != null) {
                        questionList.add(question)

                    }
                }
                val action = QuestionFragmentDirections.actionQuestionFragmentToQuizFragment(questionList.toTypedArray())
                findNavController().navigate(action)
            }
            .addOnFailureListener { exception ->
                Log.e("QuestionFragment", "Error getting documents: ", exception)
            }


    }

}