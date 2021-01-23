package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.*
import org.slf4j.LoggerFactory

class OrderService {

    private val paymentService = PaymentService()
    private val context = Context()

    fun execute(order: Order, paymentMethod: PaymentMethod) {
        logger.info("m=execute customer={}", order.customer.name)

        val pay = paymentService.pay(order, paymentMethod)

        if (pay.authorizationNumber > 0) {
            order.close()
        }

        for (item in order.getItems()) {
            when (item.product.type) {
                ProductType.PHYSICAL -> {
                    context.set(PhysicalProductStrategy())
                    context.execute(order)
                }
                ProductType.MEMBERSHIP -> {
                    context.set(MemberShipProductStrategy())
                    context.execute(order)
                }
                ProductType.BOOK -> {
                    context.set(BookProductStrategy())
                    context.execute(order)

                }
                ProductType.DIGITAL -> {
                    context.set(DigitalProductStrategy())
                    context.execute(order)
                }
            }
        }
    }

    companion object {
        private val logger = LoggerFactory.getLogger(OrderService::class.java.name)
    }
}