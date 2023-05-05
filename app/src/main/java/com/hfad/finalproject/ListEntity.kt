package com.hfad.finalproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListEntity(
    @PrimaryKey(autoGenerate = true) val listId: Int,
    @ColumnInfo val ListName: String
)
