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


class MenuFragment : Fragment(), ViewContract,RecyclerViewAdapter.OnItemClickListener {

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
            findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }

        adapter = RecyclerViewAdapter(emptyList(), this)
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
        adapter.notifyDataSetChanged()
    }

    override fun showError(message: String) {
    }

    override fun onItemClick(product: Product) {
        val action = MainFragmentDirections.actionMainFragmentToDetailFragment(product)
        findNavController().navigate(action)
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }


}
