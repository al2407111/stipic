package com.example.playlistmaker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.OnItemClickListener
import com.example.myapplication.R
import com.practicum.adapter_lesson_3.Item
import com.practicum.adapter_lesson_3.ItemsAdapter

class Activitytest2 :  AppCompatActivity() {
    var i:Int=0

    private val items: MutableList<Item> = mutableListOf()
    lateinit var adapter: ItemsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        val backToMainSettings = findViewById<ImageView>(R.id.button_back)
        backToMainSettings.setOnClickListener {
            super.finish()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)



        recyclerView.layoutManager = LinearLayoutManager(this)

        val onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(item: Item) {
                val position = items.indexOf(item)
                items.remove(item)
                adapter.notifyItemRemoved(position)
                adapter.notifyItemRangeChanged(position, items.size)
            }
        }


        adapter = ItemsAdapter(items, onItemClickListener)
        recyclerView.adapter = adapter


        val textInput = findViewById<EditText>(R.id.text_input)
        val reverseButton = findViewById<Button>(R.id.reverse_button)
        val addButton = findViewById<Button>(R.id.add_button)

        reverseButton.setOnClickListener {
            items.reverse()
            adapter.notifyDataSetChanged()
        }

        addButton.setOnClickListener {


           if (textInput.text.isNotEmpty()) {
               items.add(0, Item(R.drawable.barsik,textInput.text.toString()))
              val s=textInput.text.toString()
                i=s.toInt()
                textInput.text.clear()
                adapter.notifyItemInserted(0)
                adapter.notifyItemRangeChanged(0, items.size)


            }
            else {

               i++
               items.add(0, Item(R.drawable.barsik, i.toString()))
               textInput.text.clear()
               adapter.notifyItemInserted(0)
               adapter.notifyItemRangeChanged(0, items.size)
           }

        }

    }

}