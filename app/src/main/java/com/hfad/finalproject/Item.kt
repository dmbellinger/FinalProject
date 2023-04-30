package com.hfad.finalproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey (autoGenerate = true)
    @ColumnInfo val listId: Int,
    @ColumnInfo val name: String,
    @ColumnInfo val price: Double)
