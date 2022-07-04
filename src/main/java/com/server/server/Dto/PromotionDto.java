package com.server.server.Dto;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Employe;

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
public class PromotionDto {
  private long id;

  private String description;
  private Timestamp dateCreation;
  private Date dateDebut;
  private Date dateFin;
  private int pourcentageReduction;
  private transient Employe employe;
  private long id_produit;
}
