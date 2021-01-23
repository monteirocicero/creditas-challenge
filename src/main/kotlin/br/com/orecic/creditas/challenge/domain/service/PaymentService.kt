package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Order
import br.com.orecic.creditas.challenge.domain.Payment
import br.com.orecic.creditas.challenge.domain.PaymentMethod
import org.slf4j.LoggerFactory
import java.lang.Exception

class PaymentService {

    fun pay(order: Order, paymentMethod: PaymentMethod): Payment {
        if (paymentMethod == null)
            throw Exception("The payment method is required")

        if (order.getItems().count() == 0)
            throw Exception("Empty order can not be paid!")

        val payment = Payment(order, paymentMethod)

        logger.info("m=pay ORDER_PROCESSED payment={} customer={}", payment.authorizationNumber, order.customer.name)
        return payment
    }

    companion object {
        private val logger = LoggerFactory.getLogger(PaymentService::class.java.name)
    }

}
