package com.example.mathemania

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView




class FinishActivity : AppCompatActivity() {

    private var imageTrophy: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val textUsername: TextView = findViewById(R.id.textUsername)
        val textScore: TextView = findViewById(R.id.textScore)
        val buttonFinish: Button = findViewById(R.id.buttonFinish)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)


        imageTrophy = findViewById(R.id.imageTrophy)

        displayTrophyImage(correctAnswers)
        checkPointsPlural(correctAnswers, textScore)
        textUsername.text = intent.getStringExtra(Constants.USER_NAME)


        buttonFinish.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    private fun displayTrophyImage(score : Int) {
        when {
            score >= 100 -> imageTrophy?.setImageResource(R.drawable.trophydiamond)

            score >= 50 -> imageTrophy?.setImageResource(R.drawable.trophygold)

            score >= 25 -> imageTrophy?.setImageResource(R.drawable.trophysilver)

            score >= 10 -> imageTrophy?.setImageResource(R.drawable.trophybronze)
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