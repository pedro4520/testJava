package com.tui.proof.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.tui.proof.dto.OrderDto;

import lombok.Data;


@Entity
@Data
@Table(name = "customer_order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 45)
  private String number;

  @Column(nullable = false)
  private boolean isDelivery;

  @Column(nullable = false)
  private int pilotes;

  @Column(nullable = false)
  private double orderTotal;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "client_id", referencedColumnName = "id")
  private Client client;

  @Column(nullable = false)
  private Date orderDate;

  public Order(OrderDto order, int numberOrder) {
    
    this.setOrderDate(new Date());
    this.setDelivery(order.isDelivery());
    this.setPilotes(order.getPilotes());
    this.setOrderTotal(order.getPilotes());
    this.setNumber("ORD" + numberOrder++);
    
  }

  public Order() {
  }

  public double setOrderTotal(int pilotes) {
    double pilotePrice = 1.33;
    this.orderTotal = pilotes * pilotePrice;
    return pilotes * pilotePrice;
  }

}
