package com.example.neobis_android_inventory_app

import com.example.neobis_android_inventory_app.databinding.ItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (var product: List<Product>, val listener: OnItemClickListener) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    interface OnItemClickListener {
        fun onItemClick(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {
        lateinit var binding: ItemBinding
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, listener)

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
        holder.cardItem.setOnClickListener {
            listener.onItemClick(product[position])
        }
    }

    class ViewHolder(private val binding: ItemBinding,  private val listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.imageButton
        val name: TextView = binding.textName
        val price: TextView = binding.textPrice
        val brand: TextView = binding.textBrand
        val amount: TextView = binding.textAmount
        val cardItem: CardView = binding.cardItem
    }
}