package com.server.server.Entity;

import java.util.List;

import javax.persistence.CascadeType;
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
public class Categories {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private long position;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "categories")
  private List<Product> products;

}
