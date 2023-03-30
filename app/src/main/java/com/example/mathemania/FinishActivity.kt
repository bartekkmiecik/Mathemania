package com.example.mathemania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FinishActivity : AppCompatActivity() {

    private var imageTrophy : ImageView? = null
    private var textUsername : TextView? = null
    private var textScore : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val buttonFinish : Button = findViewById(R.id.buttonFinish)
        imageTrophy = findViewById(R.id.imageTrophy)
        textUsername = findViewById(R.id.textUsername)
        textScore = findViewById(R.id.textScore)
    }
}