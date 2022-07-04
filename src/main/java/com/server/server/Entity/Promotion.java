package com.server.server.Entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


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
public class Promotion {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String description;
  private Timestamp dateCreation;
  private Date dateDebut;
  private Date dateFin;
  private int pourcentageReduction;

  @ManyToOne()
  private Employe employe;

  private long id_produit;

  /*@OneToOne()
  private Produit produit;*/

}
