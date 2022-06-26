package io.github.baesa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BaesaApplication

fun main(args: Array<String>) {
    runApplication<BaesaApplication>(*args)
}
