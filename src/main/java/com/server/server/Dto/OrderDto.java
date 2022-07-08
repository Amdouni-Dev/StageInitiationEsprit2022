package com.server.server.Dto;

import java.util.Date;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class OrderDto {
  private long id;

  private String  status;
  private String  address;
  private Date dateOrder;


  private transient List<Notification> notifications;
  private transient Client client;
  private transient List<Product> products;

}
