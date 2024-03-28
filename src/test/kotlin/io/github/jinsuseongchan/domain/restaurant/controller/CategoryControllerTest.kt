package io.github.jinsuseongchan.domain.restaurant.controller

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.service.CategoryService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest
@AutoConfigureMockMvc
class CategoryControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val categoryService: CategoryService
) {
    @BeforeEach
    fun setUp() {
        categoryService.createCategory(Category(name = "한식"))
        categoryService.createCategory(Category(name = "중식"))
        categoryService.createCategory(Category(name = "일식"))
        categoryService.createCategory(Category(name = "양식"))
    }

    @Test
    @DisplayName("모든 카테고리 조회")
    fun getAllCategories() {
        mockMvc.get("/api/category/list")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                jsonPath("$[0].name") { value("한식") }
                jsonPath("$[1].name") { value("중식") }
                jsonPath("$[2].name") { value("일식") }
                jsonPath("$[3].name") { value("양식") }
            }
    }
}
