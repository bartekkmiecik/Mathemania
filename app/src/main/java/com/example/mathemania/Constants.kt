package com.example.mathemania

import android.view.View
import android.view.Window


object Constants {

    const val USER_NAME: String = "user_name"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val BEST_SCORE: String = "best_score"
    const val IS_READY_TO_SAVE: String = "is_ready_to_save"
    fun getRandomEquation(): Equation{
        val randomOperation = Operation.values().random()
        val randomEquation: Equation?

        when (randomOperation) {

            Operation.DIVIDE -> randomEquation = Equation((0..20).random(), 2, Operation.DIVIDE)

            Operation.MULTIPLY -> randomEquation = Equation((0..10).random(), (0..10).random(), Operation.MULTIPLY)

            else -> randomEquation = Equation((0..20).random(), (0..20).random(), randomOperation)

        }

        return randomEquation
    }

    fun hideSystemUI(window: Window) {
        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        // Hide the nav bar and status bar
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // Hide nav bar
                        or View.SYSTEM_UI_FLAG_FULLSCREEN // Hide status bar
                )
    }


}