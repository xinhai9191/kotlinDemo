package com.example.demo

import com.example.demo.utils.eq
import com.example.demo.utils.join
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "order")
class Order (
        @Id
        var id: String?,
        var userId: Int,
        var number: String,
        var money: Double,
        var num: Int
) {
        var user: User ?= null

        companion object {
                val userRelation = join(Order::user, on = Order::userId eq User::id)
        }
}