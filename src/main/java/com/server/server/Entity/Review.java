package com.server.server.Entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String  feedback;
  private int rate;
  private Date date_review;




  @JsonBackReference
  @JsonIgnore
  @ManyToOne
  private Product product;


  @JsonBackReference
  @JsonIgnore
  @ManyToOne
  private Client client;


}