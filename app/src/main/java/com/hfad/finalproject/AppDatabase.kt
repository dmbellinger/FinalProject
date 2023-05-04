package com.hfad.finalproject

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class,ListEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun DAO(): DAO
    abstract fun SavedDAO(): SavedDAO

    companion object{
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase ::class.java,
                    "list_database"
                )
                    .fallbackToDestructiveMigration().allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}