package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class CategoryServiceTest @Autowired constructor(val categoryService: CategoryService) {

    @Test
    @DisplayName("카테고리 정보를 저장할 수 있다")
    fun saveCategoryTest() {
        // given
        val category = Category(name = "테스트 카테고리")

        // when
        val savedCategory = categoryService.saveCategory(category)

        // then
        assertThat(savedCategory).isSameAs(category)
    }
}