package com.tui.proof.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tui.proof.dto.OrderDto;
import com.tui.proof.model.Client;
import com.tui.proof.model.Order;
import com.tui.proof.repository.ClientRepository;
import com.tui.proof.repository.OrderRepository;
import com.tui.proof.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    private static int numberOrder = 1;

    @Override
    public Order createOrder(OrderDto order) {
        validateNumberOfPioltes(order);

        Order newOrder = new Order(order, numberOrder++);
        Client client = clientRepository.findById(order.getClientId()).orElse(null);

        if (client == null) {
            throw new IllegalArgumentException("Client not found.");
        }

        newOrder.setClient(client);
    
        return orderRepository.save(newOrder);
    }

    @Override
    public Order updateOrder(Long id, OrderDto order) {
        validateNumberOfPioltes(order);

        Order orderToUpdate = orderRepository.findById(id).orElse(null);

        if (orderToUpdate == null) {
            return null;
        }

        if (this.hasMoreThanFiveMinutes(orderToUpdate.getOrderDate())) {
            throw new IllegalArgumentException("Order date is more than five minutes old. Because of that, it can't be updated."); 
        }

        orderToUpdate.setPilotes(order.getPilotes());
        orderToUpdate.setOrderTotal(order.getPilotes());
        orderToUpdate.setDelivery(order.isDelivery());
        orderToUpdate.setOrderDate(new Date());

        return orderRepository.save(orderToUpdate);
    }

    @Override
    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    private boolean hasMoreThanFiveMinutes(Date originalDate) {
        return (new Date().getTime() - originalDate.getTime()) > 300000;
    }

    private void validateNumberOfPioltes(OrderDto orderDto) {
        int pilotes = orderDto.getPilotes();
        if (pilotes != 5 && pilotes != 10 && pilotes != 15 ) {
            throw new IllegalArgumentException("The number of pilotes must be 5,10 or 15.");
        }
    }
}

