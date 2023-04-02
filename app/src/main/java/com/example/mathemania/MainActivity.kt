package com.example.mathemania

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.mathemania.Constants.getRandomEquation
import com.example.mathemania.Constants.isProgressReadyToSave
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
        loadData()

        if (isProgressReadyToSave){
            addBestScoresToList(intent.getSerializableExtra(Constants.BEST_SCORE) as BestScore)
            saveData()
            isProgressReadyToSave = false
        }

        buttonStart.setOnClickListener {
            if(inputName.text.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
                println(getRandomEquation())
                print(listBestScore)
            } else {
                val intent = Intent(this, QuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, inputName.text.toString())
                startActivity(intent)
                finish()
            }
        }

        buttonScore.setOnClickListener{
            val intent = Intent(this, ScoreActivity::class.java)
            intent.putExtra(Constants.BEST_SCORE, listBestScore)
            startActivity(intent)
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
        val sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE)
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