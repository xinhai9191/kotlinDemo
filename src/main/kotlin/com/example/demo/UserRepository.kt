package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


interface UserRepository : JpaRepository<User, Int>, JpaSpecificationExecutor<User> {

}