package com.example.quizapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.quizapp.model.Question
import com.example.quizapp.room.Dao
import com.example.quizapp.room.QuestionDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class QuestionViewModel(application: Application) : AndroidViewModel(application) {

    val dao = QuestionDatabase(getApplication()).dao()
    val wordList = MutableLiveData<List<Question>>()

    fun getAll(){
        viewModelScope.launch(Dispatchers.IO) {
            val list = dao.getAll()
            withContext(Dispatchers.Main){
                wordList.value = list
            }
        }
    }


    fun addWord(word : Question){
        viewModelScope.launch(Dispatchers.IO) {
            dao.addWord(word)
        }
    }

    fun deleteWord(word: Question){
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteWord(word)
            getAll()
        }
    }


}