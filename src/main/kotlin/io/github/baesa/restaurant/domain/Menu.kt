package io.github.baesa.restaurant.domain

import lombok.Getter
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Table(name = "menu")
class Menu (
    @Column(name = "name", nullable = false)
    var name: String,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    var restaurantId: Restaurant
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "picture_path")
    var picturePath: String? = null
}
