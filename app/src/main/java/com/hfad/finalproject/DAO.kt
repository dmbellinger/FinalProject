package com.hfad.finalproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlin.collections.List

@Dao
interface DAO {
    @Query("SELECT * FROM Item WHERE ListId = :listId ORDER BY category")
    fun getListItems(listId: Int): List<Item>

    @Insert
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)

    @Query("DELETE FROM Item WHERE ItemId = :itemId")
    fun deleteItemById(itemId: Int)
}