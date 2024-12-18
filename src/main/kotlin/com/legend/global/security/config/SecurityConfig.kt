package com.legend.global.security.config

import com.legend.global.filter.ExceptionHandlerFilter
import com.legend.global.filter.JwtReqFilter
import com.legend.global.security.handler.CustomAccessDeniedHandler
import com.legend.global.security.handler.CustomAuthenticationEntryPointHandler
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

class SecurityConfig(
    private val accessDeniedHandler: CustomAccessDeniedHandler,
    private val authenticationEntryPointHandler: CustomAuthenticationEntryPointHandler,
    private val jwtReqFilter: JwtReqFilter,
    private val exceptionHandlerFilter: ExceptionHandlerFilter
    ) {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain{

        http.formLogin {formLogin -> formLogin.disable()}
            .httpBasic {httpBasic -> httpBasic.disable()}

        http.csrf {csrf -> csrf.disable()}
            .cors {cors -> cors.configurationSource(corsConfigurationSource())}

        http.exceptionHandling {handling -> handling
            .accessDeniedHandler(accessDeniedHandler)
            .authenticationEntryPoint(authenticationEntryPointHandler)
        }

        http.sessionManagement {sessionManagement -> sessionManagement
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }

        http.addFilterBefore(jwtReqFilter, UsernamePasswordAuthenticationFilter::class.java)
            .addFilterBefore(exceptionHandlerFilter, JwtReqFilter::class.java)

        http.authorizeHttpRequests { httpRequests -> httpRequests
            .anyRequest().permitAll()
        }

        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {

        val configuration = CorsConfiguration()

        configuration.allowedOrigins = listOf("*")
        configuration.setAllowedMethods(
            listOf(
                HttpMethod.GET.name(),
                HttpMethod.POST.name(),
                HttpMethod.PUT.name(),
                HttpMethod.DELETE.name(),
                HttpMethod.OPTIONS.name(),
                HttpMethod.PATCH.name(),
            )
        )
        configuration.allowCredentials = true
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

}