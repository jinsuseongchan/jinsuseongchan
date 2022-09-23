package io.github.jinsuseongchan.domain.restaurant.service

import io.github.jinsuseongchan.domain.restaurant.domain.Menu
import io.github.jinsuseongchan.domain.restaurant.repository.MenuRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class MenuService(val menuRepository: MenuRepository) {

    fun saveMenu(menu: Menu): Menu {
        return menuRepository.save(menu)
    }

    fun getMenuByMenuId(menuId: Long): Menu {
        return menuRepository.findByIdOrNull(menuId) ?: throw Exception("메뉴가 존재하지 않습니다.")
    }
}
