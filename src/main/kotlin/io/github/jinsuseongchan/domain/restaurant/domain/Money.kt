package io.github.jinsuseongchan.domain.restaurant.domain

import lombok.Getter
import javax.persistence.Embeddable

@Getter
@Embeddable
class Money (var value: Int) {
    fun add(money: Money): Money {
        return Money(this.value + money.value)
    }

    fun multiply(multipler: Int): Money {
        return Money(this.value * multipler)
    }
}
