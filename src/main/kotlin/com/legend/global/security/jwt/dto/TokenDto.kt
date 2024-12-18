package com.legend.global.security.jwt.dto

class TokenDto (
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExp: Int,
    val refreshTokenExp: Int
)