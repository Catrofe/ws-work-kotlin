package com.wswork

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WsWorkKotlinApplication

fun main(args: Array<String>) {
    runApplication<WsWorkKotlinApplication>(*args)
}
