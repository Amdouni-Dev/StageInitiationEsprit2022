package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Avis;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {

}