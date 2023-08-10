package com.example.neobis_android_inventory_app.db

import android.app.Application
import androidx.room.Room

class App():Application() {

   companion object{
       lateinit var db: MainDB
   }
    override fun onCreate() {
        super.onCreate()
         db = Room.databaseBuilder(
            this,
            MainDB::class.java,
            "test db")
            .allowMainThreadQueries()
            .build()

    }
}