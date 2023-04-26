package com.hfad.finalproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ItemsViewModel(private val DAO: DAO) : ViewModel() {
    private val _currentList = 1
    val currentList: Int
        get() = _currentList

    fun addItem(itemName: String, itemPrice: Double){
        val newItem = getNewItemEntry(itemName, itemPrice)
        insertItem(newItem)
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
        lateinit var list:List<Item>
        viewModelScope.launch {
           list = DAO.getListItems(_currentList)
        }
        return list
    }

    private fun getNewItemEntry(itemName: String, itemPrice: Double): Item{
        return (
                Item(
                    listId = _currentList,
                    name = itemName,
                    price = itemPrice
                    )
                )
    }

//    object ItemArray {
//        val items = arrayListOf<Item>()
//        fun addItem(item: Item){
//            items.add(item)
//        }
//    }

}
class ItemsViewModelFactory(private val DAO: DAO) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemsViewModel::class.java)) {
            @Suppress("UNCHECK_CAST")
            return ItemsViewModel(DAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}