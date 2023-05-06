package com.hfad.finalproject
//Dylan Bellinger
//Steven Griffin
// 5/5/2023
//Final Project
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListEntity(
    @PrimaryKey(autoGenerate = true) val listId: Int,
    @ColumnInfo val ListName: String
)
