package io.github.baesa.restaurant.domain

import lombok.Getter
import org.hibernate.annotations.ColumnDefault
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
@Table(name = "restaurant")
open class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @Column(name = "name", nullable = false)
    open var name: String? = null

    @Column(name = "address", nullable = false)
    open var address: String? = null

    @Column(name = "telephone_number", nullable = false)
    open var telephoneNumber: String? = null

    @Column(name = "rating", nullable = false)
    @ColumnDefault("0.0")
    open var rating: Float? = null

    @ManyToOne
    @JoinColumn(name = "category_id")
    open var categoryId: Category? = null
}
