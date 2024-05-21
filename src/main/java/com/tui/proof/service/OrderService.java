package com.tui.proof.service;

import java.util.List;

import com.tui.proof.dto.OrderDto;
import com.tui.proof.model.Order;

public interface OrderService {
    
    Order createOrder(OrderDto order);
    Order updateOrder(Long id, OrderDto order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
}

