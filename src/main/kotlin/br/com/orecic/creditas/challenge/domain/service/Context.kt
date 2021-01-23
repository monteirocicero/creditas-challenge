package br.com.orecic.creditas.challenge.domain.service

import br.com.orecic.creditas.challenge.domain.Order

class Context {
    lateinit var strategy: Strategy

    fun set(strategy: Strategy) {
        this.strategy = strategy
    }

    fun execute(order: Order) {
        this.strategy.execute(order)
    }
}
