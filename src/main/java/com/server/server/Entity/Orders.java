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

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Orders {
  @Id
  @GeneratedValue
  private long id;

  private String  status;
  private String  address;
  private Date dateOrder;
  private String paymentMethod;
  private int total;



  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
  private List<Product> products;

  @ManyToOne
  private Client client;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
  private List<Notification> notifications;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "orders")
  private List<Carriers> carriers;


}
