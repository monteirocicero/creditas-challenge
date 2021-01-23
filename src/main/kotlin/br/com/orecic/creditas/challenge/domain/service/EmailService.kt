package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Customer
import org.slf4j.LoggerFactory

class EmailService {
    fun notify(customer: Customer) {
        logger.info("m=notify NOTIFICATION customer={}", customer.name)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(EmailService::class.java.name)
    }

}
