package com.wswork.car.entity

import com.wswork.model.entity.Model
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.sql.Timestamp
import javax.persistence.*

@Entity
@AllArgsConstructor
@NoArgsConstructor
class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var timestampRegistration: Long? = null

    @ManyToOne
    @JoinColumn(name = "model_id")
    var model: Model? = null
    var year: Int? = null
    var fuel: String? = null
    var numberDoors: Byte? = null
    var color: String? = null
}