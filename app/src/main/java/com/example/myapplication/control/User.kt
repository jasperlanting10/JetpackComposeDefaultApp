package com.example.myapplication.control

class User(name: String) {
    /**
     * create a singelton version of the user object
     */
    companion object {
        private var user: User? = null
        fun getInstance(): User {
            if (user == null) {
                user = User("Jasper Lanting")
            }
            return user ?: throw AssertionError("Instance cleared")
        }
    }

    private var currentCategory : Category?= null
    fun setCurrentCategory(newCategory : Category){
        currentCategory = newCategory
    }
    fun deleteCurrentCategory(){
        currentCategory = null
    }
    fun getCurrentCategory() : Category{
        return currentCategory ?: throw NullPointerException("ERROR current category is null")
    }


    /**
     * Shopping bag variable and methods
     */
    var shoppingBag = ArrayList<ShoppingBagProduct>()
    fun emptyShoppingBag() {
        shoppingBag.clear()
    }

    fun addProductToBag(product: ShoppingBagProduct) {
        if (shoppingBag.contains(product)) {
            for (item in shoppingBag) {
                if (item.equals(product)) {
                    item.amount.value = product.amount.value
                }
            }
        } else {
            shoppingBag.add(product)
        }
        //item is not yet in shopping bag
    }
    fun removeProductFromBag(product: ShoppingBagProduct, amountToRemove: Int = 1) {
        if (shoppingBag.contains(product)) {
            for (item in shoppingBag) {
                if (item.equals(product) && item.amount.value - amountToRemove >= 0) {
                    item.amount.value = item.amount.value - amountToRemove
                    if (item.amount.value == 0) {
                        shoppingBag.remove(item)
                    }
                }
            }
        } else {
            //TODO: throw error
        }
    }


}