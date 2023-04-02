package com.example.mathemania

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.mathemania.Constants.getRandomEquation

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {
    private var listBestScore = ArrayList<BestScore>()
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonStart: Button = findViewById(R.id.buttonStart)
        val buttonScore: Button = findViewById(R.id.buttonScore)
        val inputName: EditText = findViewById(R.id.inputName)
        val isProgressReadyToSave = intent.getBooleanExtra(Constants.IS_READY_TO_SAVE, false)
        loadData()
        
        if (isProgressReadyToSave){
            addBestScoresToList(intent.getSerializableExtra(Constants.BEST_SCORE) as BestScore)
            saveData()
            Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT)
                .show()
        }

        buttonStart.setOnClickListener {
            if(inputName.text.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                println(getRandomEquation())
            } else {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, inputName.text.toString())
                startActivity(intent)
                finish()
            }
        }

        buttonScore.setOnClickListener{
            println(listBestScore)
        }

    }
    private fun saveData() {
        val sharedPreferences = getSharedPreferences("best score", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(listBestScore)
        editor.putString("courses", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("best score", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("courses", null)
        val type: Type = object : TypeToken<ArrayList<BestScore?>?>() {}.type
        listBestScore = gson.fromJson<Any>(json, type) as ArrayList<BestScore>
    }

    private fun addBestScoresToList(bestScore: BestScore) {
        if (listBestScore.size >= 4){
            if (bestScore.score > listBestScore[4].score) {
                listBestScore.removeAt(4)
                listBestScore.add(bestScore)
                listBestScore.sortBy { it.score }
            }
        } else {
            listBestScore.add(bestScore)
            listBestScore.sortBy { it.score }
        }
    }
}