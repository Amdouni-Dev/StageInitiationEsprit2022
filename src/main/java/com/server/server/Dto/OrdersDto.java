package com.server.server.Dto;

import java.io.Serializable;
import java.util.Date;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Carriers;
import com.server.server.Entity.Client;


import com.server.server.Entity.Notification;

import com.server.server.Entity.Product;
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
public class OrdersDto implements Serializable {
  private long id;

  private String  status;
  private String  address;
  private Date dateOrder;
  private String paymentMethod;


  private transient List<Notification> notifications;
  private transient Client client;
  private transient List<Product> products;
  private transient List<Carriers> carriers;

}
