package com.server.server.Dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.*;

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
public class ClientDto implements Serializable{
  private long id;

  private String nom;
  private String prenom;
  private String email;
  private String adresse;
  private String telephone;
  private String password;
  private transient Avis avis;
  private transient Commande commande;
  private transient Panier panier;
  private transient Reclamation reclamation;
}

