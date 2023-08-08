package com.example.neobis_android_inventory_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.neobis_android_inventory_app.databinding.FragmentMenuBinding


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerMenu.layoutManager = layoutManager
        val product = arrayListOf(Product(R.drawable.icon_menu, "","","",""),
            Product(R.drawable.icon_menu,"","","",""))
        binding.recyclerMenu.adapter = RecyclerViewAdapter(product)

        return binding.root
    }
}
