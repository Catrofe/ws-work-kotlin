package com.wswork.model.entity

import com.wswork.brand.entity.Brand
import lombok.AllArgsConstructor
import javax.persistence.*

@Entity
@AllArgsConstructor
class Model {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    @ManyToOne
    @JoinColumn(name = "brand_id")
    var brand: Brand? = null
    var name: String? = null
    var valueFipe: Double? = null

}