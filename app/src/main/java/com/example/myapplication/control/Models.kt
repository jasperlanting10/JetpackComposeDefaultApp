package com.example.myapplication.control

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
    val bulletPoints : ArrayList<String>? = null,
    var numberInShoppingBag : Int = 0
)