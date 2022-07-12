package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax,Long> {

}
