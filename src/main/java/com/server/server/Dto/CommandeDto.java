package com.server.server.Dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Client;

import com.server.server.Entity.Notification;
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
public class CommandeDto {
  private long id_commande;
  private String  etat;
  private String  adresse;
  private Date date_commande;
  private long id_produit;
  private transient Client client;
  private transient List<Notification> notifications;
}
