package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Customer
import org.slf4j.LoggerFactory

class MemberShipService {
    fun active(customer: Customer) {
        logger.info("m=active ACTIVATION customer={}", customer.name)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(MemberShipService::class.java.name)
    }

}
