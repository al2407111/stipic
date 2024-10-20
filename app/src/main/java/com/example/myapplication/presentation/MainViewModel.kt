package com.example.myapplication.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.ShopLisRepositoryImpl
import com.example.myapplication.domain.DeleteShopItemUseCase
import com.example.myapplication.domain.EditShopItemUseCase
import com.example.myapplication.domain.GetShopListUseCase
import com.example.myapplication.domain.ShopItem

class MainViewModel :ViewModel(){
    private val repository=ShopLisRepositoryImpl //это не правильный слой

    private val getShopListUseCase= GetShopListUseCase(repository)
    private val deleteShopItemUseCase= DeleteShopItemUseCase(repository)
    private val editShopItemUseCase= EditShopItemUseCase(repository)

//val shopList= MutableLiveData<List<ShopItem>>()

    val shopList=getShopListUseCase.getShopList()

//    fun getShopList(){
//        val list=getShopListUseCase.getShopList()
//        //shopList.value если не из главного потока то приложения упадет
//       // shopList.postValue() можно вызывать из любого потока
//
//        shopList.value=list.value
//    }


    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
       // getShopList()
    }
    fun changeEnableState(shopItem: ShopItem){
        val newItem=shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
       // getShopList()
    }
}