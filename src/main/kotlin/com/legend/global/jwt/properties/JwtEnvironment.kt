package com.legend.global.jwt.properties

import org.springframework.boot.context.properties.ConfigurationProperties


@ConfigurationProperties(prefix = "jwt")
class JwtEnvironment (
    val accessSecret: String,
    val refreshSecret: String,
    val accessExp: Int,
    val refreshExp: Int
)