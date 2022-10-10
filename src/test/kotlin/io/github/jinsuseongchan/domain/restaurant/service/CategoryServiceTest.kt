package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class CategoryServiceTest @Autowired constructor(val categoryService: CategoryService) {

    @Transactional
    @Test
    @DisplayName("카테고리 정보를 생성할 수 있다")
    fun createCategoryTest() {
        // given
        val category = Category(name = "테스트 카테고리")

        // when
        val savedCategory = categoryService.createCategory(category)

        // then
        assertThat(savedCategory).isSameAs(category)
    }

    @Transactional
    @Test
    @DisplayName("id로 카테고리를 조회할 수 있다")
    fun getCategoryByCategoryIdTest() {
        // given
        val category = categoryService.createCategory(Category(name = "테스트 카테고리"))

        // when
        val foundCategory = categoryService.getCategoryByCategoryId(category.id!!)

        // then
        assertThat(foundCategory).isSameAs(category)
    }

    @Transactional
    @Test
    @DisplayName("모든 카테고리를 리스트로 얻을 수 있다")
    fun getAllCategoryTest() {
        // given
        val categoryList = listOf(
            Category(name = "테스트 카테고리1"),
            Category(name = "테스트 카테고리2"),
            Category(name = "테스트 카테고리3"),
            Category(name = "테스트 카테고리4")
        )
        categoryList.map { categoryService.createCategory(it) }

        // when
        val allCategory = categoryService.getAllCategory()

        // then
        assertThat(allCategory).isEqualTo(categoryList)
    }

    @Transactional
    @Test
    @DisplayName("카테고리 정보를 갱신할 수 있다")
    fun updateCategoryTest() {
        // given
        val category = categoryService.createCategory(Category(name = "테스트 카테고리"))

        // when
        category.name = "업데이트 카테고리"
        val updatedCategory = categoryService.updateCategory(category)

        // then
        assertThat(updatedCategory).isSameAs(category)
    }
}
