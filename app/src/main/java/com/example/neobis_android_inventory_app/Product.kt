package com.example.neobis_android_inventory_app

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity (tableName = "ProductDB")
data class Product (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "image")
    var  image: String,
    @ColumnInfo(name = "name")
    var  name: String,
    @ColumnInfo(name = "price")
    var  price: String,
    @ColumnInfo(name = "brand")
    var  brand: String,
    @ColumnInfo(name = "amount")
    var  amount: String):Parcelable{

    }
