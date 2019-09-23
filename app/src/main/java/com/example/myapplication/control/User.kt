package com.example.myapplication.control

class User(name: String) {
    var shoppingBag = ArrayList<Product>()

    fun emptyShoppingBag(){
        shoppingBag.clear()
    }
    fun addProductToBag(product: Product, amountToAdd : Int? = 1) {
        for (item in shoppingBag) {
            if (item.equals(product)) {
                item.numberInShoppingBag++
            } else {
                //TODO: throw error
            }
        }
    }

    fun removeProductFromBag(product: Product, amountToRemove : Int) {
        for (item in shoppingBag){
            if (item.equals(product) && item.numberInShoppingBag >= 1){
                item.numberInShoppingBag--
            } else {
                //TODO: throw error
            }
        }
        shoppingBag.remove(product)
    }
}