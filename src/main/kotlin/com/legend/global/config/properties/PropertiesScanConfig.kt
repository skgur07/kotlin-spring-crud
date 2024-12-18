package com.legend.global.config.properties

import com.legend.global.security.jwt.properties.JwtEnvironment
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationPropertiesScan(
    basePackageClasses = [
        JwtEnvironment::class
    ]
)
class PropertiesScanConfig {
}