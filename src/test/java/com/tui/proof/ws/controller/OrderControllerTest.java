package com.tui.proof.ws.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import com.tui.proof.dto.OrderDto;
import com.tui.proof.model.Order;
import com.tui.proof.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateOrder() {
        OrderDto orderDto = new OrderDto(true, 5, 1L);
        Order order = new Order();
        when(orderService.createOrder(any(OrderDto.class))).thenReturn(order);

        ResponseEntity<?> response = orderController.createOrder(orderDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(order, response.getBody());
    }

    @Test
    void testCreateOrderWrongPilotes() {
        OrderDto orderDto = new OrderDto(true, 7, 1L);
        Order order = new Order();
        when(orderService.createOrder(any(OrderDto.class))).thenReturn(order);

        ResponseEntity<?> response = orderController.createOrder(orderDto);

        System.out.println(response.getStatusCode());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            orderController.createOrder(orderDto);
        });
        
        assertEquals("The number of pilotes must be 5,10 or 15.", exception.getMessage());
    }

    @Test
    void testUpdateOrder() {
        Long orderId = 1L;
        OrderDto orderDto = new OrderDto(true, 5, 1L);
        Order order = new Order();
        when(orderService.updateOrder(eq(orderId), any(OrderDto.class))).thenReturn(order);

        ResponseEntity<?> response = orderController.updateOrder(orderId, orderDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(order, response.getBody());
    }

    @Test
    void testGetOrderById() {
        Long orderId = 1L;
        Order order = new Order();
        when(orderService.getOrderById(orderId)).thenReturn(order);

        ResponseEntity<Order> response = orderController.getOrderById(orderId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(order, response.getBody());
    }

    @Test
    void testGetAllOrders() {
        List<Order> orders = List.of(new Order(), new Order());
        when(orderService.getAllOrders()).thenReturn(orders);

        ResponseEntity<List<Order>> response = orderController.getAllOrders();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orders, response.getBody());
    }
}
