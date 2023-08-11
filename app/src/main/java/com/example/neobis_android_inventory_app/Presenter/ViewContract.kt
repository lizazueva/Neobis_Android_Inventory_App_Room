package com.example.neobis_android_inventory_app.Presenter

import com.example.neobis_android_inventory_app.Product

interface ViewContract {
    fun showProducts(products: List<Product>)
    fun showError(message: String)
}