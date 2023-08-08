package com.example.neobis_android_inventory_app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.neobis_android_inventory_app.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)



        binding.bottomMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.icon_menu -> {
                    val menuFragment = MenuFragment()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, menuFragment)
                        .commit()
                    true
                }

                else -> false
            }
        }
            return binding.root
        }
    }
