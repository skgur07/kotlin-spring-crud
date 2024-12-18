package com.legend.global.security.jwt

import com.legend.global.security.auth.CustomUserDetailsService
import com.legend.global.security.jwt.properties.JwtEnvironment
import io.jsonwebtoken.security.Keys
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets

@Component
class TokenParser(
    private val userDetailsService: CustomUserDetailsService,
    private val jwtEnv: JwtEnvironment
) {
    fun authentication(accessToken: String): UsernamePasswordAuthenticationToken {
        val authenticationDetails = userDetailsService.loadUserByUsername(getAccessTokenSubject(accessToken))
        return UsernamePasswordAuthenticationToken(authenticationDetails, "", authenticationDetails.authorities)
    }

    private fun getAccessTokenSubject(accessToken: String): String =
        TokenGenerator.getTokenBody(accessToken, Keys.hmacShaKeyFor(jwtEnv.accessSecret.toByteArray(StandardCharsets.UTF_8))).subject
}