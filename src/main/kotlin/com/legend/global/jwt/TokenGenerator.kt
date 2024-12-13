package com.legend.global.jwt

import com.legend.global.jwt.dto.TokenDto
import com.legend.global.jwt.properties.JwtEnvironment
import org.springframework.stereotype.Component

@Component
class TokenGenerator (
    private val jwtEnv: JwtEnvironment
){

    private final val TOKEN_TYPE = "tokenType"
    private final val ACCESS_TOKEN = "accessToken"
    private final val REFRESH_TOKEN = "refreshToken"

    fun generateToken(userId: String): TokenDto =
        TokenDto(

        )
}