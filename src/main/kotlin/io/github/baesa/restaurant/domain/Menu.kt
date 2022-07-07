package io.github.baesa.restaurant.domain


import lombok.Data
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
@Data
@DynamicInsert
@DynamicUpdate
@Table(name = "menu")
open class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "picture_path")
    open var picturePath: String? = null

    @Column(name = "rating", nullable = false)
    open var rating: Float? = null

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    open var restaurantId: Restaurant? = null
}
