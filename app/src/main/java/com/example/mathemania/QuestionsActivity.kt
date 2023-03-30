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
    private var textAnswerCount : TextView? = null
    private var isLastNumeric = false
    private var isLastDot = false
    private var isOperatorAdded = false
    private var correctAnswer : Double = 0.0
    private var correctAnswerCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        textAnswer = findViewById(R.id.textAnswer)
        textQuestion = findViewById(R.id.textQuestion)
        textAnswerCount = findViewById(R.id.textAnswerCount)
        setEquation()
    }

    fun digitButtonTapped(button: View){

        var correctAnswerString = correctAnswer.toString()

        if (correctAnswerString.endsWith(".0")) {
            correctAnswerString = correctAnswerString.substring(0, correctAnswerString.length - 2)
        }

        textAnswer?.let {
            if (it.text.contains(getString(R.string.answer))) {
                textAnswer?.text = ""
            }

            appendButtonTapped(button)

            checkCorrectAnswer(it, correctAnswerString)
        }


        println("${textAnswer?.text}, $correctAnswer")
    }

    private fun appendButtonTapped(button: View) {
        if ((button as Button).text == getString(R.string.clr)) {
            textAnswer?.text = getString(R.string.answer)
            isLastNumeric = false
            isLastDot = false
            isOperatorAdded = false
        } else {
            textAnswer?.append(button.text)
            isLastNumeric = true
        }
    }

    private fun checkCorrectAnswer(answerInput: TextView, correctAnswer : String) {
        if (answerInput.text.toString() == correctAnswer) {
            setEquation()
            textAnswer?.text = getString(R.string.answer)
            isLastNumeric = false
            isLastDot = false
            isOperatorAdded = false
            correctAnswerCount++
            textAnswerCount?.text = "Correct answers: $correctAnswerCount"
            println(correctAnswerCount)
        }
    }

    fun decimalPointButtonTapped(button: View) {
        if (isLastNumeric && !isLastDot) {
            textAnswer?.append(".")
            isLastNumeric = false
            isLastDot = true
        }
    }

    fun minusButtonTapped(button: View) {
        textAnswer?.let {
            if (it.text.contains(getString(R.string.answer))) {
                textAnswer?.text = ""
            }
        }

        if (!isOperatorAdded) {
            textAnswer?.append("-")
            isOperatorAdded = true
        }
    }

     private fun setEquation() {
        val randomEquation = Constants.getRandomEquation()

        when (randomEquation.operation) {
            Operation.ADD -> {
                textQuestion?.text = "${randomEquation.valueFirst} + ${randomEquation.valueSecond}"

                correctAnswer = (randomEquation.valueFirst + randomEquation.valueSecond).toDouble()

            }

            Operation.SUBTRACT -> {
                textQuestion?.text = "${randomEquation.valueFirst} - ${randomEquation.valueSecond}"

                correctAnswer = (randomEquation.valueFirst - randomEquation.valueSecond).toDouble()
            }

            Operation.DIVIDE -> {
                textQuestion?.text = "${randomEquation.valueFirst} / ${randomEquation.valueSecond}"

                correctAnswer = randomEquation.valueFirst.toDouble() / randomEquation.valueSecond.toDouble()
            }

            Operation.MULTIPLY -> {
                textQuestion?.text = "${randomEquation.valueFirst} x ${randomEquation.valueSecond}"

                correctAnswer = (randomEquation.valueFirst * randomEquation.valueSecond).toDouble()
            }
        }
    }
}