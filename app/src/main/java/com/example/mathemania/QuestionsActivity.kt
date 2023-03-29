package com.example.mathemania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class QuestionsActivity : AppCompatActivity() {

    private var textAnswer : TextView? = null
    private var textQuestion : TextView? = null
    var isLastNumeric = false
    var isLastDot = false
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        textAnswer = findViewById(R.id.textAnswer)
        textQuestion = findViewById(R.id.textQuestion)

        setEquation()
    }

    fun digitButtonTapped(button: View){
        textAnswer?.let {
            if(it.text.contains(getString(R.string.answer))) {
                textAnswer?.text = ""
            }
        }

        if((button as Button).text == getString(R.string.clr)) {
            textAnswer?.text = getString(R.string.answer)
            isLastNumeric = false
            isLastDot = false
        } else {
            textAnswer?.append(button.text)
            isLastNumeric = true
        }
    }

    fun decimalPointButtonTapped(button: View) {
        if(isLastNumeric && !isLastDot){
            textAnswer?.append(".")
            isLastNumeric = false
            isLastDot = true
        }
    }

    fun setEquation() {
        val randomEquation = Constants.getRandomEquation()

        when(randomEquation.operation) {
            Operation.ADD -> {
                textQuestion?.text = "${randomEquation.valueFirst} + ${randomEquation.valueSecond}"
            }

            Operation.SUBTRACT -> {
                textQuestion?.text = "${randomEquation.valueFirst} - ${randomEquation.valueSecond}"
            }

            Operation.DIVIDE -> {
                textQuestion?.text = "${randomEquation.valueFirst} / ${randomEquation.valueSecond}"
            }

            Operation.MULTIPLY -> {
                textQuestion?.text = "${randomEquation.valueFirst} x ${randomEquation.valueSecond}"
            }
        }
    }
}