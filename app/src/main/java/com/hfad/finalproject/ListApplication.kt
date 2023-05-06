package com.hfad.finalproject
//Dylan Bellinger
//Steven Griffin
// 5/5/2023
//Final Project
import android.app.Application

class ListApplication : Application() {
    val database : AppDatabase by lazy {AppDatabase.getDatabase(this)}
}