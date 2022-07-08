package com.server.server.Entity;

import java.util.Date;
import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String  status;
  private String  address;
  private Date dateOrder;


  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  private List<Product> products;

  @JsonBackReference
  @JsonIgnore
  @ManyToOne
  private Client client;


  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
  private List<Notification> notifications;


}
