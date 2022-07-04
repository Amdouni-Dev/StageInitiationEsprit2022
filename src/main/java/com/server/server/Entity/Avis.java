package com.server.server.Entity;







import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Avis {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id_avis;
  private String  comm;
  private int note;
  private Date date_creation;
  private long id_produit;

  @ManyToOne
  private Client client;


}