package com.example.mathemania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btnStart)
        val btnScore : Button = findViewById(R.id.btnScore)
        val inputName : EditText = findViewById(R.id.inputName)

        btnStart.setOnClickListener{
            if(inputName.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT)
            }else{
                // TODO "Make Questions activity"
            }
        }

        btnScore.setOnClickListener{
            // TODO "Make scoreboard activity"
        }

    }
}