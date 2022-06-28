package com.server.server.Repository;

import com.server.server.Entity.Produit;
import com.server.server.Entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {

}