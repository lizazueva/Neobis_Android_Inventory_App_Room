package com.example.neobis_android_inventory_app.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.neobis_android_inventory_app.Product
import java.util.UUID

@Dao
interface Dao {
    @Insert
    fun insert(product: Product)
    @Query("SELECT*FROM ProductDB")
    fun getAllProduct(): LiveData<List<Product>>
    @Query("SELECT * FROM ProductDB WHERE id =(:id)")
    fun getCrime(id: Int): LiveData<Product?>
    @Update
    fun updateProduct(product: Product)
}