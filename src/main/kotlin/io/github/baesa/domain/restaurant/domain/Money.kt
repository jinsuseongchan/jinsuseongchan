package io.github.baesa.domain.restaurant.domain

import lombok.Getter
import javax.persistence.Embeddable

@Getter
@Embeddable
open class Money(var value: Int) {
    fun add(money: Money): Money {
        return Money(this.value + money.value)
    }

    fun multiply(multipler: Int): Money {
        return Money(this.value * multipler)
    }
}
