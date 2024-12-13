package com.legend.global.jwt.dto

class TokenDto (
    val accessToken: String,
    val refreshToken: String,
    val accessTokenExp: String,
    val refreshTokenExp: String
)