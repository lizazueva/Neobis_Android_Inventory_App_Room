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
        @Volatile
        private var INSTANCE: MainDB? = null
        fun getInstance(context: Context): MainDB {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MainDB::class.java,
                        "item_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
