package com.legend.kotlinspringcrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringCrudApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringCrudApplication>(*args)
}
