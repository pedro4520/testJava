package com.tui.proof.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 45)
  private String street;

  @Column(nullable = false, length = 45)
  private String postcode;

  @Column(nullable = false, length = 45)
  private String city;

  @Column(nullable = false, length = 45)
  private String country;

  @OneToOne(mappedBy = "address")
  @JsonIgnore
  private Client client;
}
