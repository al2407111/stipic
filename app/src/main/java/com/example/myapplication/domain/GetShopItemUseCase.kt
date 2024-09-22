package com.example.myapplication.domain

class GetShopItemUse(private val shopListRepository:ShopListRepository) {
    fun getShopItem(shopItemId: Int):ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }
}