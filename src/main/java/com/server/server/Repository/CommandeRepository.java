package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Commande;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
