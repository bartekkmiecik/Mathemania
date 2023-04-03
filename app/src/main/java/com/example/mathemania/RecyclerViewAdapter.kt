package com.example.mathemania

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class RecyclerAdapter(private var scoreList: ArrayList<BestScore>): RecyclerView.Adapter<RecyclerAdapter.CourseViewHolder>() {
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): CourseViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_item,
                parent, false
            )
            return CourseViewHolder(itemView)
        }

        override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
            holder.textUsername.text = scoreList[position].username
            holder.textPoints.text = scoreList[position].score.toString()
            holder.imageTrophy.setImageResource(scoreList[position].trophySource)
        }

        override fun getItemCount(): Int {
            return scoreList.size
        }

        class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textUsername: TextView = itemView.findViewById(R.id.textUsername)
            val textPoints: TextView = itemView.findViewById(R.id.textPoints)
            val imageTrophy: ImageView = itemView.findViewById(R.id.imageTrophy)
        }
    }
