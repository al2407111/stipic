package com.example.myapplication.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.myapplication.R
import com.example.myapplication.domain.ShopItem

class ShopListAdapter:ListAdapter<ShopItem,ShopItemViewHolder>(ShopItemDiffCallBack()) {

    var count = 0
//    var shopList = listOf<ShopItem>()
//        set(value) {
//            val callback = ShopListDiffCallback(shopList, value)
//            val diffResult = DiffUtil.calculateDiff(callback)
//            diffResult.dispatchUpdatesTo(this)
//            field = value
//        }


   // var onShopItemLongClickListener: OnShopItemLongClickListener?=null
   var onShopItemLongClickListener: ((ShopItem)-> Unit)?=null

    var onShopItemClickListener: ((ShopItem)-> Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        Log.d("ShopListAdapter","onCreateViewHolder, count: ${++count}")
        val layout=when(viewType){
            VIEW_TYPE_DISABLED-> R.layout.item_shop_disabled
            VIEW_TYPE_ENABLED-> R.layout.item_shop_enabled
            else -> {throw RuntimeException("else item_shop")}
        }
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)

        viewHolder.view.setOnLongClickListener {
        //    onShopItemLongClickListener?.onShopItemLongClickListener(shopItem)
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        viewHolder.view.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)

        }
            viewHolder.tvName.text = shopItem.name
            viewHolder.tvCount.text = shopItem.count.toString()


    }

//    override fun getItemCount(): Int {
//        return shopList.size
//    }

    override fun getItemViewType(position: Int): Int {
        val item= getItem(position)
return if(item.enabled){
    VIEW_TYPE_ENABLED
}else{
    VIEW_TYPE_DISABLED
}
    }


//    interface OnShopItemLongClickListener{
//        fun onShopItemLongClickListener(shopItem: ShopItem)
//    }


    companion object{
        const val VIEW_TYPE_ENABLED=100
        const val VIEW_TYPE_DISABLED=101
        const val MAX_POOL_ZIZE=25 //мощность устройства или экран устройства размер
    }
}
