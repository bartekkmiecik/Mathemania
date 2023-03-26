package com.example.mathemania

import kotlin.random.Random

object Constants {

    fun getEquation(): Equation{
        val operation = listOf("add", "subtract", "divide", "multiply")
        val randomOperation = operation.random()
        var randomEquation: Equation? = null

        if(randomOperation == "divide"){
           randomEquation = Equation((0..20).random(), 2, "divide")
        }else {
            randomEquation = Equation((0..20).random(), (0..20).random(), randomOperation)
        }
        return randomEquation
    }

}