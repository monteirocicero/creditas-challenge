package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Order

class PhysicalProductStrategy : Strategy {

    private val shippingLabelService = ShippingLabelService()

    override fun execute(order: Order) {
        shippingLabelService.generate(order.address, order.customer)
    }

}
