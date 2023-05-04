package com.hfad.finalproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SavedDAO {
    @Query("SELECT * FROM ListEntity")
    fun getAll(): List<ListEntity>

    @Insert
    fun newList(List: ListEntity)
}