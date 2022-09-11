package io.github.jinsuseongchan.domain.restaurant.domain

import lombok.Getter
import javax.persistence.Embeddable

@Getter
@Embeddable
class Money (var money: Int) {
    fun add(money: Money): Money {
        return Money(this.money + money.money)
    }

    fun multiply(multiplier: Int): Money {
        return Money(this.money * multiplier)
    }
}
