package com.example.mathemania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate

class QuestionsActivity : AppCompatActivity() {

    private var textAnswer : TextView? = null
    var islastNumeric = false
    var islastDot = false
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        textAnswer = findViewById(R.id.textAnswer)
    }

    fun digitButtonTapped(button: View){
        textAnswer?.let {
            if(it.text.contains(getString(R.string.answer))) {
                textAnswer?.text = ""
            }
        }

        if((button as Button).text == getString(R.string.clr)) {
            textAnswer?.text = getString(R.string.answer)
            islastNumeric = false
            islastDot = false
        } else {
            textAnswer?.append(button.text)
            islastNumeric = true
        }
    }

    fun decimalPointButtonTapped(button: View) {
        if(islastNumeric && !islastDot){
            textAnswer?.append(".")
            islastNumeric = false
            islastDot = true
        }
    }
}