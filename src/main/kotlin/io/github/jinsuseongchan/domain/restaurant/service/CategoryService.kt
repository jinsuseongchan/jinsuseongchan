package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.repository.CategoryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CategoryService(val categoryRepository: CategoryRepository) {

    fun saveCategory(category: Category): Category {
        return categoryRepository.save(category)
    }

    fun getCategoryByCategoryId(categoryId: Long): Category {
        return categoryRepository.findByIdOrNull(categoryId) ?: throw Exception("카테고리 없음")
    }

    fun getAllCategory(): List<Category> {
        return categoryRepository.findAll()
    }
}
