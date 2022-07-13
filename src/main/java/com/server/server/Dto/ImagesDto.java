package com.server.server.Dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Product;
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
public class ImagesDto implements Serializable {
  private  long id;
  private Boolean isCover;
  private String name;
  private String url;
  private transient Product product;
}
