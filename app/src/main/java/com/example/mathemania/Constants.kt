package com.example.mathemania


object Constants {

    fun getRandomEquation(): Equation{
        val randomOperation = Operation.values().random()
        val randomEquation: Equation?

        if(randomOperation == Operation.DIVIDE){
           randomEquation = Equation((0..20).random(), 2, Operation.DIVIDE)
        } else {
            randomEquation = Equation((0..20).random(), (0..20).random(), randomOperation)
        }
        return randomEquation
    }

}