package com.example.neobis_android_inventory_app.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.neobis_android_inventory_app.Product

@Database (entities = [Product::class], version = 1)
abstract class MainDB: RoomDatabase() {
    abstract fun getDao(): Dao
    companion object{
        fun getDb(context: Context):MainDB{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDB::class.java,
                "test db").build()
        }
    }
}