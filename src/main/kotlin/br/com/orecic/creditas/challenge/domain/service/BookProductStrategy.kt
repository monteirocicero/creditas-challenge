package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Order

class BookProductStrategy : Strategy {

    private val shippingLabelService = ShippingLabelService()

    override fun execute(order: Order) {
        shippingLabelService.generateTaxFee(order.address, order.customer)
    }

}
