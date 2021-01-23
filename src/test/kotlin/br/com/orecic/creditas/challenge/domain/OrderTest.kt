package br.com.orecic.creditas.challenge.domain

import br.com.orecic.creditas.challenge.domain.service.OrderService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class OrderTest {

    lateinit var orderService: OrderService

    @BeforeEach
    fun init() {
        orderService = OrderService()
    }

    @Test
    fun `should execute order with sucess`() {
        // given
        val order = Order(Customer("Josefina Alves"), Address("Av. Paulista, 100 - Bela Vista São Paulo - SP, 01310-000"))

        val shirt = Product("Flowered t-shirt", ProductType.PHYSICAL, 35.00)
        val netflix = Product("Familiar plan", ProductType.MEMBERSHIP, 29.90)
        val book = Product("The Hitchhiker's Guide to the Galaxy", ProductType.BOOK, 120.00)
        val music = Product("Stairway to Heaven", ProductType.DIGITAL, 5.00)

        order.addProduct(shirt, 2)
        order.addProduct(netflix, 1)
        order.addProduct(book, 1)
        order.addProduct(music, 1)

        val paymentMethod = CreditCard("43567890-987654367")

        orderService.execute(order, paymentMethod)

    }

}
