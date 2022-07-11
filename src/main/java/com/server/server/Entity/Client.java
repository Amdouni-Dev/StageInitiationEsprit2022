package com.server.server.Entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.*;



@Data
  @NoArgsConstructor
  @AllArgsConstructor
  @Getter
  @Setter
  @Entity
  public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private String telephone;
    private String password;

    private String verificationCode;
    private boolean enabled;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
  private List<Review> reviews;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
  private List<Orders> orders;

  @JsonIgnore
  @OneToOne(cascade = CascadeType.MERGE,mappedBy = "client")
  private ShoppingCart shoppingCart;


  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
  private List<Reclamation> reclamations;


}
