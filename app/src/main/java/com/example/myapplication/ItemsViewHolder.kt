package com.practicum.adapter_lesson_3

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
class ItemsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val itemText: TextView = itemView.findViewById(R.id.item_text)
    private val itemImage: ImageView = itemView.findViewById(R.id.item_image)
    private val trackTitle: ImageView = itemView.findViewById(R.id.imageView)
    fun bind(item: Item) {
        itemImage.setImageResource(item.drawableId)
        trackTitle.setImageResource(item.drawableId)
        itemText.text = item.text

    val imageUrl = item.photo
    Glide.with(itemView)
    .load(imageUrl)
    .placeholder(R.drawable.ic_person)
    .transform(RoundedCorners(2))
    .fitCenter()
    .into(trackTitle)



}

}