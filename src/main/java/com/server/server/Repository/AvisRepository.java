package com.server.server.Repository;



import com.server.server.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Avis;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {

    @Transactional
    @Modifying
    @Query("delete from Avis a where a.id_produit=:#{#id_produit} AND a.client=:#{#client}")
    void deleteAvisnew(@Param("id_produit") long id_produit, @Param("id_client") long id_client);




    @Transactional
    @Modifying
    @Query("delete from Avis a where a.id_produit=:#{#id_produit}")
    void deleteAvisByProduit(@Param("id_produit") long id_produit);

}