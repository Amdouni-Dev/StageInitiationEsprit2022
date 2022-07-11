package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.server.server.Entity.Client;
import com.server.server.Entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReviewDto implements Serializable {
  private long id;

  private String  feed_back;
  private int rate;
  private Date date_review;

  private transient Client client;
  private transient Product product;

}
