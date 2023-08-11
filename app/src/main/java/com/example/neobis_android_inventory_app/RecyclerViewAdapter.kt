package com.example.neobis_android_inventory_app

import com.example.neobis_android_inventory_app.databinding.ItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.neobis_android_inventory_app.db.MainDB

class RecyclerViewAdapter (var product: List<Product>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        lateinit var binding: ItemBinding
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = product[position]
        holder.image.setImageResource (currentItem.image)
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price
        holder.brand.text = currentItem.brand
        holder.amount.text = currentItem.amount
    }

    class ViewHolder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.imageButton
        val name: TextView = binding.textName
        val price: TextView = binding.textPrice
        val brand: TextView = binding.textBrand
        val amount: TextView = binding.textAmount
    }
}