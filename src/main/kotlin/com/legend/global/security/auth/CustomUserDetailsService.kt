package com.legend.global.security.auth

import com.legend.global.error.GlobalException
import com.legend.kotlinspringcrud.user.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

class CustomUserDetailsService(
    private val userRepository: UserRepository
): UserDetailsService{
    override fun loadUserByUsername(userId: String): UserDetails =
        CustomUserDetails(
            userRepository.findById(userId.toLong())
                .orElseThrow { GlobalException("유저를 찾을 수 없습니다.", HttpStatus.NOT_FOUND) }
        )
}