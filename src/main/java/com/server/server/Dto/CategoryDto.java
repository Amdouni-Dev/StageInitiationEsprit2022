package com.server.server.Dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Product;
import com.server.server.Entity.Reclamation;

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
public class CategoryDto implements Serializable {
  private  long id;
  private String name;
  private String url;
  private Date dateAdd;
  private Date dateUpd;
  private transient List<Product> products;
}
