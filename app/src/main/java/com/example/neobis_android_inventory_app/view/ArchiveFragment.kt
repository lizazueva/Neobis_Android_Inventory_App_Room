package com.example.neobis_android_inventory_app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neobis_android_inventory_app.Dialog
import com.example.neobis_android_inventory_app.Presenter.ProductPresenter
import com.example.neobis_android_inventory_app.Presenter.ViewContract
import com.example.neobis_android_inventory_app.Product
import com.example.neobis_android_inventory_app.RecyclerViewAdapter
import com.example.neobis_android_inventory_app.databinding.FragmentArchiveBinding


class ArchiveFragment : Fragment(), ViewContract, RecyclerViewAdapter.OnItemClickListener, Dialog.DialogListener {

    private lateinit var binding:FragmentArchiveBinding
    private lateinit var presenter: ProductPresenter
    private lateinit var adapter: RecyclerViewAdapter
    var products = emptyList<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArchiveBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerMenuArhive.layoutManager = layoutManager
        adapter = RecyclerViewAdapter(products, this, requireContext(), this)
        binding.recyclerMenuArhive.adapter = adapter
        getAllArhived()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchViewArhive.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    getAllArhived()
                } else {
                    newText?.let { filterProducts(it) }
                }
                return true
            }
        })
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

    private fun getAllArhived() {
        presenter = ProductPresenter(requireContext())
        presenter.attachView(this)
        presenter.getAllArhived()
    }

    override fun showProducts(products: List<Product>) {
        adapter.product = products
        adapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(product: Product) {
        Toast.makeText(context, "Товар архивирован, его нельзя изменить", Toast.LENGTH_SHORT).show()
    }

    override fun onDialogClosed() {
        adapter.setData(products)
        presenter.getAllArhived()
    }


}