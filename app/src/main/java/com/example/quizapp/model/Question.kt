package com.example.quizapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "question")
@Parcelize
data class Question(
    @PrimaryKey(autoGenerate = true)
    val id : Int =0,
    var question: String = "",
    var option1: String = "",
    var option2: String = "",
    var option3: String = "",
    var option4: String = "",
    var ans: String = "",
    ): Parcelable
