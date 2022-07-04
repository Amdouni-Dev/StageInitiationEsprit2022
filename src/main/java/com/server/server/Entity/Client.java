package com.server.server.Entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
    private String password;

    private String verificationCode;
    private boolean enabled;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
  private List<Avis> avis;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
  private List<Commande> commandes;

  @JsonIgnore
  @OneToOne(cascade = CascadeType.MERGE,mappedBy = "client")
  private Panier panier;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
  private List<Reclamation> reclamations;

}
