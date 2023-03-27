package com.example.mathemania


object Constants {

    fun getEquation(): Equation{
        val randomOperation = Operations.values().random()
        val randomEquation: Equation?

        if(randomOperation == Operations.divide){
           randomEquation = Equation((0..20).random(), 2, Operations.divide)
        } else {
            randomEquation = Equation((0..20).random(), (0..20).random(), randomOperation)
        }
        return randomEquation
    }

}