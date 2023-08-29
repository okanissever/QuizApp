package com.example.quizapp.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.model.Question


@androidx.room.Dao
interface Dao {

    @Insert
    suspend fun addWord(word : Question)

    @Delete
    suspend fun deleteWord(word : Question)

    @Query("SELECT * FROM question")
    fun getAll() : List<Question>


}