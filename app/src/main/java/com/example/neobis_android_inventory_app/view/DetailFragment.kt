package com.example.neobis_android_inventory_app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.neobis_android_inventory_app.Presenter.ProductPresenter
import com.example.neobis_android_inventory_app.Presenter.ViewContract
import com.example.neobis_android_inventory_app.Product
import com.example.neobis_android_inventory_app.databinding.FragmentDetailBinding
import com.example.neobis_android_inventory_app.db.MainDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragment: Fragment(), ViewContract {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var presenter: ProductPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)


        binding.imageViewBack.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToMainFragment()
            findNavController().navigate(action)
        }

        binding.buttonCancel.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToMainFragment()
            findNavController().navigate(action)

        }

        binding.buttonAdd.setOnClickListener {
            val product = Product(null, binding.productImage.id, binding.editTextNameProduct.text.toString(),
                binding.editTextPriceProduct.text.toString(), binding.editTextBrandProduct.text.toString(),
                binding.editTextAmountProduct.text.toString())
           //Записываем добавленный продукт
            insertProduct()

        }

        return binding.root
    }

    private fun insertProduct() {
        presenter = ProductPresenter(requireContext())
        presenter.attachView(this)
        presenter.insertProduct(product)
    }

    override fun showProducts(products: List<Product>) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

}