package com.server.server.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Category {
  @Id
  private long id;
  private String name;
  private String url;
  private Date dateAdd;
  private Date dateUpd;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
  private List<Product> products;

}
