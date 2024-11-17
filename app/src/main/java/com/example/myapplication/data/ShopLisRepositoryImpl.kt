package com.example.myapplication.data

import android.widget.Button
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.R
import com.example.myapplication.domain.ShopItem
import com.example.myapplication.domain.ShopListRepository
import kotlin.random.Random

object ShopLisRepositoryImpl:ShopListRepository {
private val shopListLD=MutableLiveData<List<ShopItem>>()
   // private val shopList= mutableListOf<ShopItem>()
    private val shopList= sortedSetOf<ShopItem>( {o1,o2 ->  o1.id.compareTo(o2.id)}) //повторить сортировку
private var autoIncrement=0

   init {
       for (i in 1 until 10){
           val item=ShopItem("Name $i",i, true )
           addShopItem(item)
       }
   }


    override fun addShopItem(shopItem: ShopItem) {
       if ( shopItem.id==ShopItem.UNDEFINED_ID){
        shopItem.id=autoIncrement++
       }

        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
      shopList.remove(shopItem)
        updateList()
    }

    /*
    override fun editShopItem(shopItem: ShopItem) {
    val oldElement= getShopItem(shopItem.id)
    shopList.remove(oldElement)
    addShopItem(shopItem)
    updateList()
    }
    */

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)//stipic 3.5
    }


    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id==shopItemId
        }?:throw RuntimeException("none $shopItemId")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
      //  return shopList.toList()
        return shopListLD
    }
    private fun updateList(){
        shopListLD.value= shopList.toList()
    }

}