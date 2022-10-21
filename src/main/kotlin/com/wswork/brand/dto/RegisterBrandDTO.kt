package com.wswork.brand.dto

import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Data
@AllArgsConstructor
@NoArgsConstructor
class RegisterBrandDTO {

    @NotNull
    @NotBlank
    var nameBrand: String? = null
}