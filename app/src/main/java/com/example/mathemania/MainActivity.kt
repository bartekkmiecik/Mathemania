package com.example.mathemania

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {
    private var bestScores = ArrayList<BestScore>(5)
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonStart: Button = findViewById(R.id.buttonStart)
        val buttonScore: Button = findViewById(R.id.buttonScore)
        val inputName: EditText = findViewById(R.id.inputName)
        val isProgressReadyToSave = intent.getBooleanExtra(Constants.IS_READY_TO_SAVE, false)
        Constants.hideSystemUI(window)
        loadData()

        if (isProgressReadyToSave) {
            addBestScoreToList(intent.getSerializableExtra(Constants.BEST_SCORE) as BestScore)
            saveData()
        }

        buttonStart.setOnClickListener {
            if(inputName.text.isEmpty()) {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            } else {
                goToQuestionsActivity(inputName)
            }
        }

        buttonScore.setOnClickListener{
            goToScoreActivity()
        }

    }

    private fun goToScoreActivity() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra(Constants.BEST_SCORE, bestScores)
        startActivity(intent)
    }

    private fun goToQuestionsActivity(inputName: EditText) {
        val intent = Intent(this, QuestionsActivity::class.java)
        intent.putExtra(Constants.USER_NAME, inputName.text.toString())
        startActivity(intent)
        finish()
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences("best score", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json: String = gson.toJson(bestScores)
        editor.putString("courses", json)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences("best score", MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("courses", null)
        if (json != null) {
            val type: Type = object : TypeToken<ArrayList<BestScore?>?>() {}.type
            bestScores = gson.fromJson<Any>(json, type) as ArrayList<BestScore>
        }
    }

    private fun addBestScoreToList(bestScore: BestScore) {
        if (bestScores.size >= 5){
            if (bestScore.score > bestScores[4].score) {
                bestScores.removeAt(4)
                bestScores.add(bestScore)
                println("done")
            }
        } else {
            bestScores.add(bestScore)
        }
        bestScores.sortedByDescending { it.score }
    }
}