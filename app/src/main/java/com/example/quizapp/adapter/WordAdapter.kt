package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.ItemWordBinding
import com.example.quizapp.model.Question
import com.example.quizapp.viewmodel.QuestionViewModel

class WordAdapter(private val viewModel: QuestionViewModel) : ListAdapter<Question,WordAdapter.WordHolder>(NoteDiffCallback ) {


    object NoteDiffCallback : DiffUtil.ItemCallback<Question>() {
        override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem == newItem
        }
    }

    class WordHolder(val binding : ItemWordBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val binding = ItemWordBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return WordHolder(binding)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        val item = currentList[position]

        holder.binding.wordTv.text = item.question
        holder.binding.ansTv.text = item.ans

        holder.binding.imgDelete.setOnClickListener{
            viewModel.deleteWord(item)
        }

    }
}