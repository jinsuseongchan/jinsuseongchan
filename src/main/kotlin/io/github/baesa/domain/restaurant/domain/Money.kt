package io.github.baesa.domain.restaurant.domain

class Money(private val value: Int) {
    fun add(money: Money): Money {
        return Money(this.value + money.value)
    }

    fun multiply(multipler: Int): Money {
        return Money(this.value * multipler)
    }
}
