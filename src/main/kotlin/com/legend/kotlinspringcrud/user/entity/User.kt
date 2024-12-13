package com.legend.kotlinspringcrud.user.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class User (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    val id: Long = 0,

    @Column(nullable = false, columnDefinition = "VARCHAR(100)")
    val email: String,

    @Column(nullable = false, columnDefinition = "VARCHAR(25)")
    val password: String,

    @Column(nullable = false,columnDefinition = "VARCHAR(30)")
    val name: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "authority")
    val authority: Authority
)