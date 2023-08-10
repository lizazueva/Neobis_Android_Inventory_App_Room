package com.example.neobis_android_inventory_app.db

import androidx.lifecycle.LiveData
import com.example.neobis_android_inventory_app.Product

//хранилище данных
class Repository(val productDao: Dao) {
    val getAllProduct:LiveData<List<Product>> = productDao.getAllProduct()

    fun insert(product: Product){
        productDao.insert(product)
    }

}