package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Panier;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

    @Transactional
    @Query("Select p from Panier p where p.client.id=:#{#id_client}")
   public Optional<Panier> findByClientoooId (@Param("id_client") long id_client);

    //Optional<Panier> findAllByClient (long id_client);

    //Optional<Panier> findByClient (long id_client);
    //Optional<Panier> findByClientId(long id_client);


    @Transactional
    @Modifying
    @Query("delete from Panier p where p.id_produit=:#{#id_produit} AND p.client.id=:#{#id_client}")
    void deleteProduitPanierByProduitAndClient(@Param("id_produit") Collection<Integer> id_produit, @Param("id_client") long id_client);

}
