package com.wswork.car.dto

import lombok.AllArgsConstructor
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@AllArgsConstructor
class EditCarDTO {

    var modelId: Long? = null
    var year: Int? = null
    var fuel: String? = null
    var numberDoors: Byte? = null
    var color: String? = null

}