package com.hfad.finalproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ListEntity(
    @PrimaryKey val listId: Int,
    @ColumnInfo val ListName: String
)
