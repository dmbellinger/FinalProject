package com.hfad.finalproject

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SavedDAO {
    @Query("SELECT * FROM SavedLists")
    fun getAll(): List<ListEntity>

    @Insert
    fun newList(listEntity: com.hfad.finalproject.ListEntity)
}