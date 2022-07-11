package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Images;

@Repository
public interface ImagesRepository extends JpaRepository<Images,Long> {

}
