package com.amlavati.creationaldesignpattern


/**
 * properties:
 * there can be only one object created
 * constructor has to be private
 *
 */
class SingletonPattern {
    private var itemsInCart = 0
    fun addToCart() {
        itemsInCart++
    }

    fun getCartCount() = itemsInCart
}


object SinglePatternImpl {

    private var itemsInCart = 0
    fun addToCart() {
        itemsInCart++
    }

    fun getCartCount() = itemsInCart
}