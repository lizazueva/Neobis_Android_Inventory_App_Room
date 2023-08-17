package com.example.neobis_android_inventory_app.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neobis_android_inventory_app.Presenter.ProductPresenter
import com.example.neobis_android_inventory_app.Presenter.ViewContract
import com.example.neobis_android_inventory_app.Product
import com.example.neobis_android_inventory_app.R
import com.example.neobis_android_inventory_app.RecyclerViewAdapter
import com.example.neobis_android_inventory_app.databinding.FragmentMenuBinding


class MenuFragment : Fragment(), ViewContract,RecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var presenter: ProductPresenter
    private lateinit var adapter: RecyclerViewAdapter
    var products = emptyList<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerMenu.layoutManager = layoutManager

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_detailFragment)
        }

        adapter = RecyclerViewAdapter(products, this,requireContext())
        binding.recyclerMenu.adapter = adapter
//        adapter.setData(products)

        getAllProducts()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    getAllProducts()
                } else {
                    newText?.let { filterProducts(it) }
                }
                return true
            }
            })
        }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume() called")
        adapter.setData(products)

    }

    private fun filterProducts(query: String) {
        val filteredList = mutableListOf<Product>()
        for (product in adapter.product) {
            if (product.name.contains(query, ignoreCase = true)) {
                filteredList.add(product)
            }
        }
        adapter.product = filteredList
        adapter.notifyDataSetChanged()
    }

    private fun getAllProducts() {
        presenter = ProductPresenter(requireContext())
        presenter.attachView(this)
        presenter.getAllProducts()
    }

    override fun showProducts(products: List<Product>) {
        adapter.product = products
        adapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
    }

    override fun onItemClick(product: Product) {
        val action = MenuFragmentDirections.actionMenuFragmentToDetailFragment(product)
        findNavController().navigate(action)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}

