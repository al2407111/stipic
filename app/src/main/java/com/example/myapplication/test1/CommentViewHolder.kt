package com.practicum.recyclerview_lesson_1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.myapplication.R
import com.github.javafaker.Color

class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val userNumberView: TextView
    private val commentTextView: TextView
    private val commentTextView2: TextView
    private val commentTextView3: TextView
    private val trackTitle: ImageView = itemView.findViewById(R.id.imageView)
    init {
        userNumberView = itemView.findViewById(R.id.userNumber)
        commentTextView = itemView.findViewById(R.id.commentText)
        commentTextView2 = itemView.findViewById(R.id.commentText2)
        commentTextView3 = itemView.findViewById(R.id.commentText3)
    }

    fun bind(model: Comment) {
        userNumberView.text = "#${model.userNumber}"

        commentTextView.text = model.commentText
        commentTextView2.text = model.commentText2
        if (model.i>3) {
            commentTextView2.setTextColor(android.graphics.Color.RED)
        } else {
            commentTextView2.setTextColor(android.graphics.Color.BLUE)
        }


        commentTextView3.text = "#${model.i}"
        // Изображение
        val imageUrl = model.photo
        Glide.with(itemView)
            .load(imageUrl)
            .placeholder(R.drawable.ic_person)
            .transform(RoundedCorners(2))
            .fitCenter()
            .into(trackTitle)
    }
}