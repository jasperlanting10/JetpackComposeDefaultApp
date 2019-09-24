package com.example.myapplication.control

import androidx.compose.State

data class Category(
    val name : String,
    val image : Int,
    val products : ArrayList<Product>? = null
)

data class Product(
    val name : String,
    val description : String,
    val image : Int,
    val price : Double,
    val bulletPoints : ArrayList<String>? = null
)

data class ShoppingBagProduct(
    val product: Product,
    var amount : State<Int>
)