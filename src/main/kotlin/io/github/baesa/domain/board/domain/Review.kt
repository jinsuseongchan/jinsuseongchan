package io.github.baesa.domain.board.domain

import io.github.baesa.domain.restaurant.domain.Restaurant
import io.github.baesa.domain.user.domain.User
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
@Table(name = "review")
class Review (
    @ManyToOne
    @JoinColumn(name = "user_id")
    var userId: User,

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    var restaurantId: Restaurant,

    @Column(name = "post_script", nullable = false)
    var postScript: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "picture_path")
    var picturePath: String? = null
}
