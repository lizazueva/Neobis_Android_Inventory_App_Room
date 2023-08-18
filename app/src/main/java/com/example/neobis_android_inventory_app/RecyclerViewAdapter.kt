package com.example.neobis_android_inventory_app

import android.content.Context
import com.example.neobis_android_inventory_app.databinding.ItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class RecyclerViewAdapter (var product: List<Product>, val listener: OnItemClickListener, val context: Context, val dialogListener: Dialog.DialogListener) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

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
        Glide.with(holder.image).load(currentItem.image).into(holder.image)
        holder.name.text = currentItem.name
        holder.price.text = currentItem.price
        holder.brand.text = currentItem.brand
        holder.amount.text = currentItem.amount
        holder.cardItem.setOnClickListener {
            listener.onItemClick(product[position])
        }
        val dialogUtils = Dialog(context)

        holder.dots.setOnClickListener {
            dialogUtils.dialog(holder.dots.context, currentItem, dialogListener)
            }
        }

    class ViewHolder(private val binding: ItemBinding,  private val listener: OnItemClickListener) : RecyclerView.ViewHolder(binding.root) {
        val image: ImageView = binding.imageButton
        val name: TextView = binding.textName
        val price: TextView = binding.textPrice
        val brand: TextView = binding.textBrand
        val amount: TextView = binding.textAmount
        val cardItem: CardView = binding.cardItem
        val dots: ImageView = binding.iconThreeDots
    }

    fun setData(newProduct: List<Product>){
        val diffUtil = DiffUtils(product, newProduct)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        diffResult.dispatchUpdatesTo(this)
    }
}