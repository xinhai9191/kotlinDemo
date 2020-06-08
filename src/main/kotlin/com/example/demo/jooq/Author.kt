package com.example.demo.jooq

import java.util.*

class Author (
        var id: Int ?= null,
        var firstName: String,
        var lastName: String,
        var dateOfBirth: Date,
        var yearOfBirth: Int,
        var distinguished: Int
)