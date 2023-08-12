package com.example.neobis_android_inventory_app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.neobis_android_inventory_app.Presenter.ProductPresenter
import com.example.neobis_android_inventory_app.Presenter.ViewContract
import com.example.neobis_android_inventory_app.Product
import com.example.neobis_android_inventory_app.R
import com.example.neobis_android_inventory_app.databinding.FragmentDetailBinding


 class DetailFragment: Fragment(), ViewContract {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var presenter: ProductPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val product = arguments?.getParcelable<Product?>("product")
        if (product != null) {
            binding.editTextNameProduct.setText(product.name)
            binding.editTextPriceProduct.setText(product.price)
            binding.editTextBrandProduct.setText(product.brand)
            binding.editTextAmountProduct.setText(product.amount)
            binding.buttonAdd.setText("Сохранить")
            binding.textAddProduct.setText("Детали о товаре")
        }


        binding.imageViewBack.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToMainFragment()
            findNavController().navigate(action)
        }

        binding.buttonCancel.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToMainFragment()
            findNavController().navigate(action)

        }

        binding.buttonAdd.setOnClickListener {
            //Записываем добавленный продукт
            insertProduct()

        }

        return binding.root
    }

    private fun insertProduct() {
        presenter = ProductPresenter(requireContext())
        presenter.attachView(this)
        val product = Product(
            0,
            R.drawable.placeholder_image,
            binding.editTextNameProduct.text.toString(),
            binding.editTextPriceProduct.text.toString(),
            binding.editTextBrandProduct.text.toString(),
            binding.editTextAmountProduct.text.toString()
        )
        val name = product.name
        val price = product.price
        val brand = product.brand
        val amount = product.amount
        if (validate(name, price, brand, amount)) {
            presenter.insertProduct(product)
            Toast.makeText(requireContext(), "Товар добавлен", Toast.LENGTH_SHORT).show()
            val action = DetailFragmentDirections.actionDetailFragmentToMainFragment()
            findNavController().navigate(action)
        } else {
            Toast.makeText(requireContext(), "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        }
    }

    private fun validate(name: String, price: String, brand: String, amount: String): Boolean {
        if (name.isEmpty() || price.isEmpty() || brand.isEmpty() || amount.isEmpty()) {
            return false
        }

        return true
    }

    override fun showProducts(products: List<Product>) {
        TODO("Not yet implemented")
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
