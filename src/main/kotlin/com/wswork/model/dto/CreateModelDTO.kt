package com.wswork.model.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Data
@AllArgsConstructor
@NoArgsConstructor
class CreateModelDTO {

    @NotBlank
    @NotNull
    var name: String? = null

    @NotNull
    var valueFipe: Double? = null

    @NotNull
    var brandId: Long? = null
}