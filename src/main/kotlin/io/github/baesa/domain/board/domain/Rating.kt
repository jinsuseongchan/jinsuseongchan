package io.github.baesa.domain.board.domain

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
@Table(name = "rating")
class Rating (
    @ManyToOne
    @JoinColumn(name = "review_id")
    var reviewId: Review,

    @Column(name = "value", nullable = false)
    var value: Float
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null
}
