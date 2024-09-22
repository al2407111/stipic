package com.example.myapplication.data

import com.example.myapplication.domain.ShopItem
import com.example.myapplication.domain.ShopListRepository

object ShopLisRepositoryImpl:ShopListRepository {

    private val shopList= mutableListOf<ShopItem>()
private var autoIncrement=0

    override fun addShopItem(shopItem: ShopItem) {
       if ( shopItem.id==ShopItem.UNDEFINED_ID){
        shopItem.id=autoIncrement++
       }

        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
      shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
      val oldElement= getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id==shopItemId
        }?:throw RuntimeException("none $shopItemId")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}