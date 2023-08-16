package com.example.neobis_android_inventory_app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.neobis_android_inventory_app.R
import com.example.neobis_android_inventory_app.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.icon_menu -> {
                    parentFragmentManager.beginTransaction()
                        .remove(parentFragmentManager.findFragmentById(R.id.fragment_container)!!)
                        .commit()
                    val menuFragment = MenuFragment()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, menuFragment)
                        .commit()
                    true
                }
                else -> {
                    parentFragmentManager.beginTransaction()
                        .remove(parentFragmentManager.findFragmentById(R.id.fragment_container)!!)
                        .commit()
                    val archiveFragment = ArchiveFragment()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, archiveFragment)
                        .commit()
                    true
                }
            }
        }
    }

        override fun onResume() {
            super.onResume()
            val menuFragment = MenuFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .commit()
        }

}
