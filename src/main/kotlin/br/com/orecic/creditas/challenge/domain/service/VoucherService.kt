package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Customer
import org.slf4j.LoggerFactory

class VoucherService {
    fun generate(customer: Customer) {
        logger.info("m=generate CREATE customer={}", customer.name)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(VoucherService::class.java.name)
    }

}
