package com.hfad.finalproject
//Dylan Bellinger
//Steven Griffin
// 5/5/2023
//Final Project
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SavedListViewModel(private  val SavedDAO: SavedDAO): ViewModel(){

}
//class SavedListViewModelFactory(private val ListDAO: SavedDAO) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(SavedListViewModel::class.java)) {
//            @Suppress("UNCHECK_CAST")
//            return ItemsViewModel(SavedDAO) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//
//}