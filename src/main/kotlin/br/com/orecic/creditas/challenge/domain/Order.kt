package br.com.orecic.creditas.challenge.domain

import java.util.*


class Order(val customer: Customer, val address: Address) {


    private val items = mutableListOf<OrderItem>()

    var closedAt: Date? = null
        private set

    val totalAmount
        get() = items.sumByDouble { it.total }

    fun addProduct(product: Product, quantity: Int) {
        var productAlreadyAdded = items.any { it.product == product }
        if (productAlreadyAdded)
            throw Exception("The product have already been added. Change the amount if you want more.")

        items.add(OrderItem(product, quantity))
    }

    internal fun close() {
        closedAt = Date()
    }
    
    fun getItems(): MutableList<OrderItem> {
        return items
    }

}