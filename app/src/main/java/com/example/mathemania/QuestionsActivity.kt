package com.example.mathemania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class QuestionsActivity : AppCompatActivity() {

    private var textAnswer : TextView? = null
    var lastNumeric = false
    var lastDot = false
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        textAnswer = findViewById(R.id.textAnswer)
    }

    fun click(button: View){
        if(textAnswer?.text!!.contains("ANSWER")) {
            textAnswer?.text = ""
        }

        if((button as Button).text == "CLR") {
            textAnswer?.text = "ANSWER"
            lastNumeric = false
            lastDot = false
        } else {
            textAnswer?.append(button.text)
            lastNumeric = true
        }
    }

    fun decimalPoint(button: View) {
        if(lastNumeric && !lastDot){
            textAnswer?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }
}