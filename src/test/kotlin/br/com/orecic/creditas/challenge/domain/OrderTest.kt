package br.com.orecic.creditas.challenge.domain

import br.com.orecic.creditas.challenge.domain.service.EmailService
import br.com.orecic.creditas.challenge.domain.service.MemberShipService
import br.com.orecic.creditas.challenge.domain.service.ShippingLabelService
import br.com.orecic.creditas.challenge.domain.service.VoucherService
import org.junit.jupiter.api.Test

class OrderTest {

    @Test
    fun `should execute order with sucess`() {

        val shirt = Product("Flowered t-shirt", ProductType.PHYSICAL, 35.00)
        val netflix = Product("Familiar plan", ProductType.MEMBERSHIP, 29.90)
        val book = Product("The Hitchhiker's Guide to the Galaxy", ProductType.BOOK, 120.00)
        val music = Product("Stairway to Heaven", ProductType.DIGITAL, 5.00)

        val order = Order(Customer("Josefina Alves"), Address("Rua Pereira do Lago 309 Vila Gomes 05590000"))

        order.addProduct(shirt, 2)
        order.addProduct(netflix, 1)
        order.addProduct(book, 1)
        order.addProduct(music, 1)

        order.pay(CreditCard("43567890-987654367"))
        // now, how to deal with shipping rules then?
        val shippingLabelService = ShippingLabelService()
        val memberShipService = MemberShipService()
        val emailService = EmailService()
        val voucherService = VoucherService()


        for (item in order.getItems()) {

            when (item.product.type) {
                ProductType.PHYSICAL -> shippingLabelService.generate(order.address, order.customer)
                ProductType.MEMBERSHIP -> {
                    memberShipService.active(order.customer)
                    emailService.notify(order.customer)
                }
                ProductType.BOOK -> shippingLabelService.generateTaxFee(order.address, order.customer)
                ProductType.DIGITAL -> {
                    emailService.notify(order.customer)
                    voucherService.generate(order.customer)
                }
            }
        }
    }

}
