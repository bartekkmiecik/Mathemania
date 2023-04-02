package com.example.mathemania



object Constants {

    const val USER_NAME: String = "user_name"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val BEST_SCORE: String = "best_score"
    var isProgressReadyToSave = false

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
}