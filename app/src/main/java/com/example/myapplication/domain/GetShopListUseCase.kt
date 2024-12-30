package com.example.myapplication.domain

import androidx.lifecycle.LiveData
import com.example.myapplication.data.ShopListRepositoryImpl

class GetShopListUseCase(private val shopListRepository: ShopListRepositoryImpl) {

    fun getShopList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList()
    }
}