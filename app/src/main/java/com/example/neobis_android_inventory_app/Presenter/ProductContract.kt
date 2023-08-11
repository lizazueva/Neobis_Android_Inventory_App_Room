package com.example.neobis_android_inventory_app.Presenter

import com.example.neobis_android_inventory_app.Product


interface ProductContract {
        fun getAllProducts()
        fun insertProduct(product: Product)
        fun getProduct(id: Int)
        fun updateProduct(product: Product)
}