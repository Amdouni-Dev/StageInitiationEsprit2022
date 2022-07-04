package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Long> {

}
