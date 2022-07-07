package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Avis;
import com.server.server.Entity.Commande;
import com.server.server.Entity.Panier;
import com.server.server.Entity.Promotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProduitDto {
    private long id;
    private long manufacturer;

    //private PriceLargeQuantities priceLargeQuantities;
    private transient Promotion promotion;
    private transient List<Avis> avis;
    private transient Panier panier;

    private transient Commande commande;


}