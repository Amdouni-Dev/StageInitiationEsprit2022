package com.server.server.Dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Avis;
import com.server.server.Entity.Client;
import com.server.server.Entity.Commande;
import com.server.server.Entity.Panier;

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
}

