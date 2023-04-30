package com.hfad.finalproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DAO {
    @Query("SELECT * FROM List WHERE ListId = :listId")
    fun getListItems(listId: Int): List<Item>

    @Insert
    fun insertItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}