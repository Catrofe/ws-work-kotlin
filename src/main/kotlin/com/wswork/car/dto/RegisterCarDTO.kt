package com.wswork.car.dto

import lombok.AllArgsConstructor
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@AllArgsConstructor
class RegisterCarDTO {

    @NotNull
    var modelId: Long? = null

    @NotNull
    var year: Int? = null

    @NotNull
    @NotBlank
    var fuel: String? = null

    @NotNull
    var numberDoors: Byte? = null

    @NotNull
    @NotBlank
    var color: String? = null

}