package io.github.jinsuseongchan.domain.board.domain

import io.github.jinsuseongchan.domain.restaurant.domain.Restaurant
import io.github.jinsuseongchan.domain.user.domain.User
import lombok.Getter
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import java.sql.Timestamp
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
    var postScript: String,

    @Column(name = "is_deleted", nullable = false)
    @ColumnDefault("TRUE")
    var isDeleted: Boolean
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "picture_path")
    var picturePath: String? = null

    @CreationTimestamp
    var createdAt: Timestamp? = null
}
