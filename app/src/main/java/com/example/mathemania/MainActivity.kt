package com.example.mathemania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.example.mathemania.Constants.getRandomEquation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart : Button = findViewById(R.id.buttonStart)
        val buttonScore : Button = findViewById(R.id.buttonScore)
        val inputName : EditText = findViewById(R.id.inputName)

        buttonStart.setOnClickListener{
            if(inputName.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                println(getRandomEquation())
            } else {
                startActivity(Intent(this, QuestionsActivity::class.java))
                finish()
            }
        }

        buttonScore.setOnClickListener{
            // TODO "Make scoreboard activity"
        }

    }
}