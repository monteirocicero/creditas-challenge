package br.com.orecic.creditas.challenge.domain

data class Invoice(val order: Order) {
    val billingAddress: Address = order.address
    val shippingAddress: Address = order.address
}
