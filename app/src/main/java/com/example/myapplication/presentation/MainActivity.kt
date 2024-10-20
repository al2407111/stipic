package com.example.myapplication.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.shopList.observe(this) {
//           Log.d("MainActivityTest",it.toString())
//if (count==0 ){
//    count++
//    val item=it[2]
//    viewModel.changeEnableState(item)
//}
//        }
           showList(it)
        }
    }
private fun showList(list: List<ShopItem>){

}
}



