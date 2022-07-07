package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.server.server.Entity.Client;
import com.server.server.Entity.Produit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AvisDto {
  private long id_avis;
  private String  comm;
  private int note;
  private Date date_creation;
  private transient Client client;
  private transient Produit produit;

}
