package com.server.server.Dto;

import java.io.Serializable;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.*;


import com.server.server.Entity.Review;
import com.server.server.Entity.Order;
import com.server.server.Entity.ShoppingCart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientDto implements Serializable{
  private long id;

  private String first_name;
  private String last_name;
  private String email;
  private String address;
  private String telephone;
  private String password;
  private transient List <Review> reviews;
  private transient List<Order> orders;

  private transient ShoppingCart shoppingCart;

  private transient List < Reclamation> reclamation;

}

