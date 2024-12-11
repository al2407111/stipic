package com.practicum.adapter_lesson_3

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ItemsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val itemText: TextView = itemView.findViewById(R.id.item_text)
    private val itemImage: ImageView = itemView.findViewById(R.id.item_image)

    fun bind(item: Item) {
        itemImage.setImageResource(item.drawableId)
        itemText.text = item.text
    }
}