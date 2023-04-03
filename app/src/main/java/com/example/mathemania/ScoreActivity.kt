package com.example.mathemania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ScoreActivity : AppCompatActivity() {

    private lateinit var scoreListAdapter: RecyclerAdapter
    private var scoreRecycler: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
        val scoreList = intent.getSerializableExtra(Constants.BEST_SCORE) as ArrayList<BestScore>
        scoreRecycler = findViewById(R.id.bestScoreList)

        val linearLayoutManager = object : LinearLayoutManager(this) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }

        scoreRecycler?.layoutManager = linearLayoutManager


        scoreListAdapter = RecyclerAdapter(scoreList)
        scoreRecycler?.adapter = scoreListAdapter

    }

}
