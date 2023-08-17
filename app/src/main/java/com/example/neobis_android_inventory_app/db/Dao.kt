package com.example.neobis_android_inventory_app.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.neobis_android_inventory_app.Product
import java.util.UUID

@Dao
interface Dao {
    @Insert
    suspend fun insert(product: Product)
    @Query("SELECT*FROM ProductDB WHERE arhived = 0")
    suspend fun getAllProduct(): List<Product>
    @Query("SELECT*FROM ProductDB WHERE arhived = 1")
    suspend fun getAllArhived(): List<Product>
    @Query("SELECT * FROM ProductDB WHERE id =(:id)")
    fun getProduct(id: Int): LiveData<Product?>
    @Update
    suspend fun updateProduct(product: Product)
    @Delete
    suspend fun deleteProduct(product: Product)
}