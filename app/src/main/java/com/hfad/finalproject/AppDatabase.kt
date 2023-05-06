package com.hfad.finalproject
//Dylan Bellinger
//Steven Griffin
// 5/5/2023
//Final Project
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class,ListEntity::class], version = 3)
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