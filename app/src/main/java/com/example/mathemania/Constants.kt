package com.example.mathemania


object Constants {

    fun getRandomEquation(): Equation{
        val randomOperation = Operation.values().random()
        val randomEquation: Equation?

        if(randomOperation == Operation.divide){
           randomEquation = Equation((0..20).random(), 2, Operation.divide)
        } else {
            randomEquation = Equation((0..20).random(), (0..20).random(), randomOperation)
        }
        return randomEquation
    }

}