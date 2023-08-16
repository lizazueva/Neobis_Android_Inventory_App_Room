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
                    replaceFragment(MenuFragment())
                    true
                }
                else -> {
                    replaceFragment(ArchiveFragment())
                    true
                }
            }
        }
    }

        override fun onResume() {
            super.onResume()
            replaceFragment(MenuFragment())
        }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

}
