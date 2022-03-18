package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.exception.ResourceNotFoundException;
import com.tilek.spring.neobis.model.Order;
import com.tilek.spring.neobis.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    final OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('order:read')")
    List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('order:read')")
    ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No order found with id: " + id));
        return ResponseEntity.ok(order);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('order:write')")
    Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('order:write')")
    ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        Order updateOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No order found with id: " + id));
        updateOrder.setAmount(orderDetails.getAmount());
        updateOrder.setPrice(orderDetails.getPrice());
        updateOrder.setCountry(orderDetails.getCountry());
        updateOrder.setCity(orderDetails.getCity());
        updateOrder.setAddress(orderDetails.getAddress());
        updateOrder.setOrderDate(orderDetails.getOrderDate());
        updateOrder.setProduct(orderDetails.getProduct());

        orderRepository.save(updateOrder);

        return ResponseEntity.ok(updateOrder);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('order:write')")
    ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No order found with id: " + id));

        orderRepository.deleteById(id);

        return ResponseEntity.ok(order);
    }
}
