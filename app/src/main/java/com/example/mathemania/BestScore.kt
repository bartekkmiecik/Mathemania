package com.example.mathemania

data class BestScore(
    val username: String,
    val score: Int,
    val trophy: TrophyEnum
): java.io.Serializable
