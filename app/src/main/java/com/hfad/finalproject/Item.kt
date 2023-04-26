package com.hfad.finalproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey (autoGenerate = true)
    val listId: Int,
    val name: String,
    val price: Double)
