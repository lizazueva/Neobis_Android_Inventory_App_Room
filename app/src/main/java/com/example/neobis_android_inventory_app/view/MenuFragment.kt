package com.example.neobis_android_inventory_app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neobis_android_inventory_app.Presenter.ProductPresenter
import com.example.neobis_android_inventory_app.Presenter.ViewContract
import com.example.neobis_android_inventory_app.Product
import com.example.neobis_android_inventory_app.R
import com.example.neobis_android_inventory_app.RecyclerViewAdapter
import com.example.neobis_android_inventory_app.databinding.FragmentMenuBinding
import com.example.neobis_android_inventory_app.db.Dao
import com.example.neobis_android_inventory_app.db.Repository


class MenuFragment : Fragment(), ViewContract {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var presenter: ProductPresenter
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerMenu.layoutManager = layoutManager

        binding.floatingActionButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment()
            findNavController().navigate(action)
        }

        adapter = RecyclerViewAdapter(emptyList())
        binding.recyclerMenu.adapter = adapter

        getAllProducts()


        return binding.root
    }
    private fun getAllProducts() {
        presenter = ProductPresenter(requireContext())
        presenter.attachView(this)
        presenter.getAllProducts()
    }

    override fun showProducts(products: List<Product>) {
        adapter.product = products
    }

    override fun showError(message: String) {
    }


}
