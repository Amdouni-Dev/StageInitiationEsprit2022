package com.server.server.Entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;

import javax.persistence.ElementCollection;
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
public class Commande {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id_commande;

  private String  etat;
  private String  adresse;

  private Date date_commande;
  @ElementCollection
  private Collection<Integer> id_produit;
  @ManyToOne
  private Client client;
  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
  private List<Notification> notifications;


}
