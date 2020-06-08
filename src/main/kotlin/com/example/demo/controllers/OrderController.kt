package com.example.demo.controllers

import com.example.demo.Order
import com.example.demo.OrderRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*


@RestController
class OrderController(
        private val orderRepo: OrderRepository
) {
    @GetMapping("/orders")
    fun orders(pageable: Pageable): Page<Order> {

        return orderRepo.findAll(pageable)
    }

    @PostMapping("/order")
    fun addOrder(@RequestBody order: Order) {
        orderRepo.save(order)
    }

    @PutMapping("/order/{id}")
    fun saveOrder(@PathVariable("id") id: String,
                  @RequestBody order: Order) {
        order.id = id
        orderRepo.save(order)
    }

    @GetMapping("/order/{id}")
    fun show(@PathVariable("id") order: Order): Order? {
        return order
    }

    @DeleteMapping("/order/{id}")
    fun deleteOrder(@PathVariable("id") id: String) {
        orderRepo.deleteById(id)
    }
}
