package com.hfad.finalproject

import android.app.Application

class ListApplication : Application() {
    val database : AppDatabase by lazy {AppDatabase.getDatabase(this)}
}