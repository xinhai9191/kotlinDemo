package com.example.demo.controllers

import com.example.demo.Order
import com.example.demo.jooq.AuthorRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
class AuthorController (
    private val authorRepo: AuthorRepository
) {
    @GetMapping("/author")
    fun orders(pageable: Pageable): Page<Order> {
        return authorRepo.findAll(pageable)
    }
}
