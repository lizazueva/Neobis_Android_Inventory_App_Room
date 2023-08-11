package com.example.neobis_android_inventory_app.db

import androidx.lifecycle.LiveData
import com.example.neobis_android_inventory_app.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

//хранилище данных
open class Repository(val productDao: Dao) {
    suspend fun getAllProduct(): List<Product> {
        return  withContext(Dispatchers.IO){
            productDao.getAllProduct()
        }
    }

    suspend fun insert(product: Product){
        return  withContext(Dispatchers.IO){
            productDao.insert(product)
        }
    }

    fun getProduct(id: Int): LiveData<Product?>{
        return productDao.getProduct(id)
    }

    fun updateProduct(product: Product){
        productDao.updateProduct(product)
    }

}