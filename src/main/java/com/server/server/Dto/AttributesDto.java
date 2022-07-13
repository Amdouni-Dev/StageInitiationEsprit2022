package com.server.server.Dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.AttributeGroup;
import com.server.server.Entity.Attributes;
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
public class AttributesDto implements Serializable {
  private long id;
  private  String name;
  private  String isoCode;
  private transient AttributeGroup attributeGroup;
  private transient Product product;
}
