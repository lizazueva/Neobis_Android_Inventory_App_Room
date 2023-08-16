package com.example.neobis_android_inventory_app.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neobis_android_inventory_app.Presenter.ProductPresenter
import com.example.neobis_android_inventory_app.Presenter.ViewContract
import com.example.neobis_android_inventory_app.Product
import com.example.neobis_android_inventory_app.R
import com.example.neobis_android_inventory_app.RecyclerViewAdapter
import com.example.neobis_android_inventory_app.databinding.FragmentArchiveBinding
import com.example.neobis_android_inventory_app.databinding.FragmentDetailBinding


class ArchiveFragment : Fragment(), ViewContract, RecyclerViewAdapter.OnItemClickListener {

    private lateinit var binding:FragmentArchiveBinding
    private lateinit var presenter: ProductPresenter
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentArchiveBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerMenuArhive.layoutManager = layoutManager
        adapter = RecyclerViewAdapter(emptyList(), this)
        binding.recyclerMenuArhive.adapter = adapter
        getAllArhived()
        return binding.root
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


}