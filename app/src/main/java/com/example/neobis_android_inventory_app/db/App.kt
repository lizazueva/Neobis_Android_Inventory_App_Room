package com.example.neobis_android_inventory_app.db

import android.app.Application
import androidx.room.Room

class App():Application() {
    class App():Application() {

        class InventoryApplication: Application() {
            val database: MainDB by lazy { MainDB.getInstance(this) }
        }
    }
}