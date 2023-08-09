package com.example.neobis_android_inventory_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.neobis_android_inventory_app.databinding.FragmentDetailBinding
import com.example.neobis_android_inventory_app.databinding.FragmentMenuBinding

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        binding.imageViewBack.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToMainFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }
}