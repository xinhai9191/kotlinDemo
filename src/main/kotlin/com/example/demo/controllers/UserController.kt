package com.example.demo.controllers

import com.example.demo.User
import com.example.demo.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
class UserController (
        private val userRepo: UserRepository
) {
    @PostMapping("/add")
    fun addUser(@RequestBody user: User) {
        userRepo.save(user)
    }

    @PutMapping("/user/{id}")
    fun editUser(@RequestBody user: User) {
        userRepo.save(user)
    }

    @GetMapping("/user/{id}")
    fun show(@PathVariable("id") id: Int): User? {
        return userRepo.findByIdOrNull(id)
    }

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable("id") id: Int) {
        userRepo.deleteById(id)
    }


}