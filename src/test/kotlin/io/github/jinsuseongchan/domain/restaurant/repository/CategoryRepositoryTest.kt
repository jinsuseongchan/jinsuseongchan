package io.github.jinsuseongchan.domain.restaurant.repository

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@DataJpaTest(showSql = true)
class CategoryRepositoryTest @Autowired constructor(val categoryRepository: CategoryRepository) {

    @Nested
    @DisplayName("카테고리 정보 저장 테스트")
    inner class CategorySaveTest {

        @Test
        @DisplayName("카테고리 정보를 저장할 수 있다")
        fun succeedSavingCategoryInfo() {
            // given
            val category = Category(name = "테스트 카테고리")

            // when
            val savedCategory = categoryRepository.save(category)

            // then
            assertThat(savedCategory).isSameAs(category)
        }
    }

    @Nested
    @DisplayName("카테고리 정보 조회 테스트")
    inner class CategoryLookUpTest {

        @Test
        @DisplayName("카테고리 아이디로 카테고리를 조회할 수 있다")
        fun succeedLookingUpCategory() {
            // given
            val savedCategory = categoryRepository.save(Category(name = "테스트 카테고리"))
            val savedCategoryId = savedCategory.id?:1L

            // when
            val foundCategory = categoryRepository.findByIdOrNull(savedCategoryId)

            // then
            assertThat(foundCategory).isSameAs(savedCategory)
        }

        @Test
        @DisplayName("카테고리 리스트를 얻을 수 있다")
        fun succeedGetCategoryList() {
            // given
            val categoryList = listOf(
                Category(name = "테스트 카테고리1"),
                Category(name = "테스트 카테고리2"),
                Category(name = "테스트 카테고리3")
            )
            categoryList.map { categoryRepository.save(it) }

            // when
            val savedCategoryList = categoryRepository.findAll()

            assertThat(savedCategoryList).isEqualTo(categoryList)
        }

        @Test
        @DisplayName("없는 카테고리 아이디로 조회하면 null을 얻는다")
        fun failLookingUpCategoryCauseNotExistId() {
            // given
            val id = 10L

            // when
            val foundCategory = categoryRepository.findByIdOrNull(id)

            assertThat(foundCategory).isNull()
        }
    }
}
