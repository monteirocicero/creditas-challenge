package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Order

interface Strategy {
    fun execute(order: Order)
}