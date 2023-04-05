package com.symplifica.test.controller;

import com.symplifica.test.model.Order;
import com.symplifica.test.model.Product;
import com.symplifica.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("")
    public Order createOrder(@RequestBody Product order) {
        return orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }

    @PostMapping("/{orderId}/add-product")
    public Order addProductToOrder(@PathVariable Long orderId, @RequestBody Product product) {
        Order order = orderService.getOrderById(orderId);
        Product products = order.getProducts();
        order.setProducts(products);
        return orderService.updateOrder(order);
    }
}