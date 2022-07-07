package com.server.server.Entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Panier {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id_panier;



  @OneToOne()
  private Client client;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "panier")
  private List<Produit> produits;

}
