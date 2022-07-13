package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Attributes;

@Repository
public interface AttributesRepository extends JpaRepository<Attributes,Long> {

}
