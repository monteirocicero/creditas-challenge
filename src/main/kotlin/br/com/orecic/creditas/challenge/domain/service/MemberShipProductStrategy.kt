package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Order

class MemberShipProductStrategy : Strategy {

    private val memberShipService = MemberShipService()
    private val emailService = EmailService()


    override fun execute(order: Order) {
        memberShipService.active(order.customer)
        emailService.notify(order.customer)
    }

}
