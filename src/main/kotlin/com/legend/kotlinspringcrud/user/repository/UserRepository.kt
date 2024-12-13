package com.legend.kotlinspringcrud.user.repository

import com.legend.kotlinspringcrud.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>