package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(val categoryRepository: CategoryRepository) {

    fun saveCategory(category: Category): Category {
        return categoryRepository.save(category)
    }

    fun getAllCategory(): List<Category> {
        return categoryRepository.findAll()
    }
}
