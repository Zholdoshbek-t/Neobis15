package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.entity.Order;
import com.tilek.spring.neobis.exception.ResourceNotFoundException;
import com.tilek.spring.neobis.model.OrderModel;
import com.tilek.spring.neobis.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public ResponseEntity<Order> getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order was not found"));

        return ResponseEntity.ok(order);
    }

    @Override
    public Order createOrder(OrderModel orderModel) {
        Order order = new Order();

        mergeOrders(order, orderModel);

        return orderRepository.save(order);
    }

    @Override
    public ResponseEntity<Order> updateOrder(Long id, OrderModel orderDetails) {
        Order updateOrder = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order was not found"));

        mergeOrders(updateOrder, orderDetails);

        orderRepository.save(updateOrder);

        return ResponseEntity.ok(updateOrder);
    }

    @Override
    public ResponseEntity<Order> deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order was not found"));

        orderRepository.deleteById(id);

        return ResponseEntity.ok(order);
    }

    private void mergeOrders(Order order, OrderModel orderModel) {
        order.setAmount(orderModel.getAmount());
        order.setPrice(orderModel.getPrice());
        order.setCountry(orderModel.getCountry());
        order.setCity(orderModel.getCity());
        order.setAddress(orderModel.getAddress());
        order.setOrderDate(orderModel.getOrderDate());
        order.setProduct(orderModel.getProduct());
    }
}
