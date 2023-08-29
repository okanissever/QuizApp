package com.example.quizapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrueFalse(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val dogru : Int = 0,
    val yanlis : Int = 0,
)