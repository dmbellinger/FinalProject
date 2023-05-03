package com.hfad.finalproject

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlin.collections.List

class ItemsViewModel(private val DAO: DAO, private val savedDAO: SavedDAO) : ViewModel() {
    private var _currentList = 1
    val currentList: Int
        get() = _currentList

    fun addItem(itemName: String, itemPrice: Double, categoryName: String, quantity: Int){
        val newItem = getNewItemEntry(itemName, itemPrice, quantity, categoryName)
        insertItem(newItem)
    }
    fun changeList(newList: Int){
        _currentList = newList
    }

    private fun insertItem(newItem: Item) {
        viewModelScope.launch {
            DAO.insertItem(newItem)
        }
    }
    fun isEntryValid(itemName: String): Boolean{
        if (itemName.isBlank()) {
            return false
        }
        return true
    }
    fun getItems(): List<Item> {
        lateinit var list: List<Item>
        viewModelScope.launch {
           list = DAO.getListItems(_currentList)
        }
        return list
    }

    fun deleteItem(item: Item){
        viewModelScope.launch {
            DAO.deleteItem(item)
        }
    }
    fun deleteByItemId(itemId: Int){
        viewModelScope.launch {
            DAO.deleteItemById(itemId)
        }
    }

    private fun getNewItemEntry(itemName: String, itemPrice: Double, quantity: Int, categoryName: String): Item{
        return (
                Item(
                    itemId = getItems().size + 1,
                    listId = _currentList,
                    name = itemName,
                    price = itemPrice,
                    quantity = quantity,
                    category = categoryName
                    )
                )
    }

     fun getSavedLists():List<ListEntity>{
        lateinit var list: List<ListEntity>
        viewModelScope.launch {
            list = savedDAO.getAll()
        }
        return list
    }

//    object ItemArray {
//        val items = arrayListOf<Item>()
//        fun addItem(item: Item){
//            items.add(item)
//        }
//    }

}
class ItemsViewModelFactory(private val DAO: DAO, private val SavedDAO: SavedDAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            @Suppress("UNCHECK_CAST")
            return ItemsViewModel(DAO, SavedDAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}