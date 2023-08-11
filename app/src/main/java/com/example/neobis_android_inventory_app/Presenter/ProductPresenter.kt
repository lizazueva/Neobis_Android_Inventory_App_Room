package com.example.neobis_android_inventory_app.Presenter

import android.content.Context
import com.example.neobis_android_inventory_app.Product
import com.example.neobis_android_inventory_app.db.MainDB
import com.example.neobis_android_inventory_app.db.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductPresenter(context: Context): ProductContract {

    private var view: ViewContract? = null
    private val repository: Repository

    init {
        val dao = MainDB.getInstance(context)?.getDao()
        repository = dao?.let { Repository(it) }!!
    }

    override fun getAllProducts() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val products = withContext(Dispatchers.IO) {
                    repository.getAllProduct()
                }
                view?.showProducts(products)
            } catch (e: Exception) {
                view?.showError(e.message ?: "Unknown error occurred")
            }
        }
    }

    override fun insertProduct(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            repository.insert(product)
        }
    }

    override fun getProduct(id: Int) {
        repository.getProduct(id)
    }

    override fun updateProduct(product: Product) {
        repository.updateProduct(product)
    }

    fun attachView(view: ViewContract) {
        this.view = view
    }

    fun detachView() {
        view = null
    }
}