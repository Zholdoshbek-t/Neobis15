package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.entity.Order;
import com.tilek.spring.neobis.model.OrderModel;
import com.tilek.spring.neobis.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    List<Order> getAllOrder() {
        return orderService.getAllOrder();
    }

    @GetMapping("{id}")
    ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    Order createOrder(@RequestBody OrderModel orderModel) {
        return orderService.createOrder(orderModel);
    }

    @PutMapping("{id}")
    ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody OrderModel orderDetails) {
        return orderService.updateOrder(id, orderDetails);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        return orderService.deleteOrder(id);
    }
}
