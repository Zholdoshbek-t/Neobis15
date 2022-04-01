package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.entity.Order;
import com.tilek.spring.neobis.model.OrderModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrder();
    List<Order> getOrdersByCity(String city);
    ResponseEntity<Order> getOrderById(Long id);
    Order createOrder(OrderModel orderModel);
    ResponseEntity<Order> updateOrder(Long id, OrderModel orderDetails);
    ResponseEntity<Order> deleteOrder(Long id);

}
