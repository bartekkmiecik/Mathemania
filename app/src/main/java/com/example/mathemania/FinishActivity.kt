package com.example.mathemania

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class FinishActivity : AppCompatActivity() {

    private var imageTrophy: ImageView? = null
    private var trophy: TrophyType = TrophyType.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val textUsername: TextView = findViewById(R.id.textUsername)
        val textScore: TextView = findViewById(R.id.textScore)
        val buttonFinish: Button = findViewById(R.id.buttonFinish)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val playerUsername = intent.getStringExtra(Constants.USER_NAME).toString()
        val isProgressReadyToSave = true

        imageTrophy = findViewById(R.id.imageTrophy)

        displayTrophyImage(correctAnswers)
        checkPointsPlural(correctAnswers, textScore)
        textUsername.text = playerUsername

        var userScore = BestScore(playerUsername, correctAnswers, trophy)


        buttonFinish.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(Constants.IS_READY_TO_SAVE, isProgressReadyToSave)
            intent.putExtra(Constants.BEST_SCORE, userScore)
            startActivity(intent)
            finish()
        }

    }

    private fun displayTrophyImage(score : Int) {
        when {
            score >= 100 -> {
                imageTrophy?.setImageResource(R.drawable.trophydiamond)
                trophy = TrophyType.DIAMOND
            }

            score >= 50 -> {
                imageTrophy?.setImageResource(R.drawable.trophygold)
                trophy = TrophyType.GOLD
            }

            score >= 25 -> {
                imageTrophy?.setImageResource(R.drawable.trophysilver)
                trophy = TrophyType.SILVER
            }

            score >= 10 -> {
                imageTrophy?.setImageResource(R.drawable.trophybronze)
                trophy = TrophyType.BRONZE
            }
        }
    }

    private fun checkPointsPlural(score: Int, view: TextView) {
        if (score == 1) {
            view.text = "Your score is $score point!"
        } else {
            view.text = "Your score is $score points!"
        }
    }
}