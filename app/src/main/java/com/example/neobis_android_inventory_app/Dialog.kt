package com.example.neobis_android_inventory_app

import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.neobis_android_inventory_app.Presenter.ProductPresenter
import com.example.neobis_android_inventory_app.Presenter.ViewContract
import com.example.neobis_android_inventory_app.databinding.BottomSheetDialogArchiveBinding
import com.example.neobis_android_inventory_app.databinding.BottomSheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class Dialog(private val context: Context): ViewContract {

    interface DialogListener {
        fun onDialogClosed()
    }

    private var listener: DialogListener? = null
    private var presenter = ProductPresenter(context)

    fun dialog(context: Context, currentItem: Product, listener: DialogListener) {
        this.listener = listener
        if (!currentItem.arhived) {
            val binding: BottomSheetDialogBinding =
                BottomSheetDialogBinding.inflate(LayoutInflater.from(context))
            val dialog = BottomSheetDialog(context)
            dialog.setContentView(binding.root)
            binding.textArhive.setOnClickListener {
                alert_dialog_menu(context, currentItem)
                dialog.dismiss()
            }
            dialog.show()
        } else {
            val binding: BottomSheetDialogArchiveBinding =
                BottomSheetDialogArchiveBinding.inflate(LayoutInflater.from(context))
            val dialog = BottomSheetDialog(context)
            dialog.setContentView(binding.root)
            binding.textRecovery.setOnClickListener {
                alert_dialog_recovery(context, currentItem)
                dialog.dismiss()
            }
            binding.textDelete.setOnClickListener {
                alert_dialog_delete(context, currentItem)
                dialog.dismiss()
            }
            dialog.show()
        }
    }

    private fun alert_dialog_menu(context: Context, currentItem: Product) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Архивировать ${currentItem.name} из каталога?")
        builder.setNegativeButton("Нет") { dialog, i ->
            Toast.makeText(context, "Товар ${currentItem.name}  не архивирован", Toast.LENGTH_SHORT)
                .show()
            dialog.dismiss()
        }
        builder.setPositiveButton("Да") { dialog, i ->
            currentItem.arhived = true
            presenter.updateProduct(currentItem)
            Toast.makeText(context, "Товар ${currentItem.name} архивирован", Toast.LENGTH_SHORT)
                .show()
            listener?.onDialogClosed()
            dialog.dismiss()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun alert_dialog_recovery(context: Context, currentItem: Product) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Восстановить ${currentItem.name} из каталога?")
        builder.setNegativeButton("Нет") { dialog, i ->
            Toast.makeText(
                context,
                "Товар ${currentItem.name}  не восстановлен",
                Toast.LENGTH_SHORT
            ).show()
            dialog.dismiss()
        }
        builder.setPositiveButton("Да") { dialog, i ->
            currentItem.arhived = false
            presenter.updateProduct(currentItem)
            Toast.makeText(context, "Товар ${currentItem.name} восстановлен", Toast.LENGTH_SHORT)
                .show()
            listener?.onDialogClosed()
            dialog.dismiss()
    }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    fun alert_dialog_delete(context: Context, currentItem: Product) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Удалить ${currentItem.name} из архива?")
        builder.setNegativeButton("Нет") { dialog, i ->
            Toast.makeText(context, "Товар ${currentItem.name}  не удален", Toast.LENGTH_SHORT)
                .show()
            dialog.dismiss()
        }
        builder.setPositiveButton("Да") { dialog, i ->
            presenter.deleteProduct(currentItem)
            presenter.getAllArhived()
            Toast.makeText(context, "Товар ${currentItem.name} удален", Toast.LENGTH_SHORT).show()
            listener?.onDialogClosed()
            dialog.dismiss()
        }

        val alertDialog = builder.create()
        alertDialog.show()
    }

    override fun showProducts(products: List<Product>) {

    }

    override fun showError(message: String) {

    }
}