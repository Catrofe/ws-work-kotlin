package com.wswork.model.dto

import lombok.AllArgsConstructor
import lombok.Data

@Data
@AllArgsConstructor
class EditModelDTO {
    var name: String? = null
    var valueFipe: Double? = null
    var brandId: Long? = null
}