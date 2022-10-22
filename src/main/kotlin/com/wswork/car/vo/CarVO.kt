package com.wswork.car.vo

import lombok.AllArgsConstructor
import lombok.Data
import java.sql.Timestamp

@Data
@AllArgsConstructor
class CarVO {
    var id: Long? = null
    var marca_id: Long? = null
    var marca_nome: String? = null
    var nome_modelo: String? = null
    var ano: Int? = null
    var combustivel: String? = null
    var num_portas: Byte? = null
    var valor_fipe: Double? = null
    var cor: String? = null
    var timestamp_cadastro: Long? = null

}