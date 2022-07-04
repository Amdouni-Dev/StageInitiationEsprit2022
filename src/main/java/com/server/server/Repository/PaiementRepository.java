package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Paiement;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {

}
