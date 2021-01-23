package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Order

class DigitalProductStrategy : Strategy {

    private val emailService = EmailService()
    private val voucherService = VoucherService()

    override fun execute(order: Order) {
        emailService.notify(order.customer)
        voucherService.generate(order.customer)
    }

}
