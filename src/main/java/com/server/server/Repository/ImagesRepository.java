package com.server.server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Images;
import com.server.server.Entity.Product;

@Repository
public interface ImagesRepository extends JpaRepository<Images,Long> {
  public List<Images> findAllByProductId(long id_product);
}
