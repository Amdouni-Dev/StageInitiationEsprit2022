package com.server.server.Repository;


import java.util.Optional;

import com.server.server.Entity.Client;
import com.server.server.Entity.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Produit;
@Repository

public interface ProduitRepository  extends JpaRepository<Produit, Long> {


    void deleteProduitByIdAndPanier(long id_produit,long id_panier);

}