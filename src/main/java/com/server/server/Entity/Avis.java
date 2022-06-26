package com.server.server.Entity;







import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import com.server.server.Entity.Client;
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

  private int id_produit;

  @ManyToOne
  @JoinColumn(name = "id_client")
  private Client client;

}
