package br.com.orecic.creditas.challenge.domain

import org.slf4j.LoggerFactory.getLogger
import java.lang.Exception
import java.util.*


class Order(val customer: Customer, val address: Address) {

    private val items = mutableListOf<OrderItem>()

    var closedAt: Date? = null
        private set

    var payment: Payment? = null
        private set

    val totalAmount
        get() = items.sumByDouble { it.total }

    fun addProduct(product: Product, quantity: Int) {
        var productAlreadyAdded = items.any { it.product == product }
        if (productAlreadyAdded)
            throw Exception("The product have already been added. Change the amount if you want more.")

        items.add(OrderItem(product, quantity))
    }

    fun pay(method: PaymentMethod) {
        if (payment != null)
            throw Exception("The order has already been paid!")

        if (items.count() == 0)
            throw Exception("Empty order can not be paid!")

        payment = Payment(this, method)

        close()

        logger.info("m=pay ORDER_PROCESSED payment={} customer={} address={}", payment!!.authorizationNumber, customer.name, address.address)

    }

    private fun close() {
        closedAt = Date()
    }
    
    fun getItems(): MutableList<OrderItem> {
        return items
    }

    companion object {
        private val logger = getLogger(Order::class.java.name)
    }
}