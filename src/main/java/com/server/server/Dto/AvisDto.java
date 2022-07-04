package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.server.server.Entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Optional;

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
  private long id_produit;
  private transient Client client;

}