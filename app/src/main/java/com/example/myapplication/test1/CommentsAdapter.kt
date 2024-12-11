package com.practicum.recyclerview_lesson_1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import androidx.core.content.ContextCompat
import com.example.myapplication.OnItemClickListener
import com.example.myapplication.R

class CommentAdapter(
    private val comments: List<Comment>,

) : RecyclerView.Adapter<CommentViewHolder> () {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comment_view, parent, false)
        return CommentViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bind(comments[position])

    }

    override fun getItemCount() = comments.size
}