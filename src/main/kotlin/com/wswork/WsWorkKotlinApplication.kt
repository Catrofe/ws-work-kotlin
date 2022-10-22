package com.wswork

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.*

@SpringBootApplication
class WsWorkKotlinApplication

fun main(args: Array<String>) {
    TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"))
    runApplication<WsWorkKotlinApplication>(*args)
}
