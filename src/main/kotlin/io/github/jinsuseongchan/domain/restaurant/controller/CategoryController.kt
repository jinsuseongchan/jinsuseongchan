package io.github.jinsuseongchan.domain.restaurant.controller

import io.github.jinsuseongchan.domain.restaurant.domain.Category
import io.github.jinsuseongchan.domain.restaurant.service.CategoryService
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Slf4j
@RestController
@RequestMapping("/api/category")
class CategoryController {
    @Autowired
    lateinit var categoryService: CategoryService

    @PostMapping("/create")
    fun createCategory(@RequestBody category: Category): Category {
        return categoryService.createCategory(category)
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable id: Long): Category {
        return categoryService.getCategoryByCategoryId(id)
    }

    @GetMapping("/list")
    fun getCategoryList(): List<Category> {
        return categoryService.getAllCategory()
    }

    @PatchMapping("/update")
    fun updateCategory(@RequestBody category: Category): Category {
        return categoryService.updateCategory(category)
    }
}
