package com.example.quizapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quizapp.model.Question


@Database(entities = [Question::class], version = 1)
abstract class QuestionDatabase : RoomDatabase(){

    abstract fun dao() : Dao

    companion object{
        @Volatile private var instance : QuestionDatabase? = null
        private val lock = Any()
        operator fun invoke(context: Context) = instance?: synchronized(lock){
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }
        private fun makeDatabase(context: Context) = Room.
        databaseBuilder(context.applicationContext,QuestionDatabase::class.java,"questiondatabase").build()
    }
}