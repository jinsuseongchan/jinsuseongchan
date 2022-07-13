package io.github.baesa.global.util

import io.github.baesa.global.domain.Authority
import javax.persistence.AttributeConverter

class AuthorityConverter: AttributeConverter<Authority, Int> {
    override fun convertToDatabaseColumn(attribute: Authority): Int {
        TODO("Not yet implemented")
    }

    override fun convertToEntityAttribute(dbData: Int): Authority {
        TODO("Not yet implemented")
    }
}
