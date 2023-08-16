package com.example.neobis_android_inventory_app

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.neobis_android_inventory_app.databinding.BottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class Dialog{


    fun dialog (context: Context, currentItem: Product) {
        if (!currentItem.arhived) {
            fun showSheet(context: Context, currentItem: Product) {
                val binding: BottomSheetDialogBinding =
                    BottomSheetDialogBinding.inflate(LayoutInflater.from(context))
                val dialog = BottomSheetDialog(context)
                dialog.setContentView(binding.root)
                binding.textArhive.setOnClickListener {
                    alert_dialog_menu(context, currentItem)
                    dialog.dismiss()
                }
                dialog.show()
            }
        }else{
            fun showSheet(context: Context, currentItem: Product) {
                val binding: BottomSheetDialogBinding =
                    BottomSheetDialogBinding.inflate(LayoutInflater.from(context))
                val dialog = BottomSheetDialog(context)
                dialog.setContentView(binding.root)
                binding.textArhive.setOnClickListener {
                    alert_dialog_menu(context, currentItem)
                    dialog.dismiss()
                }
                dialog.show()
            }
        }
    }

    private fun alert_dialog_menu(context: Context, currentItem: Product){
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Архивировать ${currentItem.name} из каталога?")
        builder.setNegativeButton("Нет"){dialog, i ->
            Toast.makeText(context, "Товар ${currentItem.name}  не архивирован", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.setPositiveButton("Да"){dialog, i ->
            currentItem.arhived = true
            Toast.makeText(context, "Товар ${currentItem.name} архивирован", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun alert_dialog_archive(context: Context, currentItem: Product){
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Архивировать ${currentItem.name} из каталога?")
        builder.setNegativeButton("Нет"){dialog, i ->
            Toast.makeText(context, "Товар ${currentItem.name}  не архивирован", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        builder.setPositiveButton("Да"){dialog, i ->
            currentItem.arhived = true
            Toast.makeText(context, "Товар ${currentItem.name} архивирован", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}