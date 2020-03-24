package com.example.demo

import javax.persistence.*

@Entity
@Table(name = "user")
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,
        var name: String,
        var email: String
)
