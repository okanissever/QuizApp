package com.example.quizapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.databinding.ItemQuestionBinding

class QuestionAdapter(private val onItemClick: (position: Int) -> Unit) : RecyclerView.Adapter<QuestionHolder>() {


    private val list = List(6) { "Test ${it + 1}" }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionHolder {
        val binding = ItemQuestionBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return QuestionHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        val item = list[position]

        holder.binding.number.text = (position+1).toString()

        holder.binding.test.text = item

        holder.binding.root.setOnClickListener{
            onItemClick(position)
        }
    }
}

class QuestionHolder(val binding : ItemQuestionBinding) : RecyclerView.ViewHolder(binding.root)


