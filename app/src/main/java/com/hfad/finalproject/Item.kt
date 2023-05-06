package com.hfad.finalproject
//Dylan Bellinger
//Steven Griffin
// 5/5/2023
//Final Project
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey val itemId: Int,
    @ColumnInfo val listId: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val price: Double,
    @ColumnInfo val quantity: Int,
    @ColumnInfo val category: String)
