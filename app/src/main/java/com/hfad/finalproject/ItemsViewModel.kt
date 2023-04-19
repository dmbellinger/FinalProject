package com.hfad.finalproject

import androidx.lifecycle.ViewModel

class ItemsViewModel : ViewModel() {
    public val items = arrayListOf<Item>()

    object ItemArray {
        val items = arrayListOf<Item>()
        fun addItem(item: Item){
            items.add(item)
        }
    }

}