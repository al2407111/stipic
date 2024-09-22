package com.example.myapplication.presentation

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ShopLisRepositoryImpl
import com.example.myapplication.domain.DeleteShopItemUseCase
import com.example.myapplication.domain.EditShopItemUseCase
import com.example.myapplication.domain.GetShopListUseCase

class MainViewModel :ViewModel(){
    private val repository=ShopLisRepositoryImpl

    private val getShopListUseCase= GetShopListUseCase(repository)
    private val deleteShopItemUseCase= DeleteShopItemUseCase(repository)
    private val editShopItemUseCase= EditShopItemUseCase(repository)


}