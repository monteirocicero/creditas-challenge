package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Address
import br.com.orecic.creditas.challenge.domain.Customer
import org.slf4j.LoggerFactory

class ShippingLabelService {

    fun generate(address: Address, customer: Customer) {
        logger.info("m=generate LABEL address={} customer={}", address.address, customer.name)
    }

    fun generateTaxFee(address: Address, customer: Customer) {
        generate(address, customer)
        logger.info("m=generateTaxFee LABEL_TAX_FEE")
    }

    companion object {
        private val logger = LoggerFactory.getLogger(ShippingLabelService::class.java.name)
    }

}
