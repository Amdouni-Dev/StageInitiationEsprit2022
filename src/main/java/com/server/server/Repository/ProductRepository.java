package com.server.server.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Product;
import com.server.server.Entity.Review;

@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {



    public List<Product> findAllByCategoryId(long id_category);

    @Query(value = "select * from product s where s.name like %:keyword% or s.id like %:keyword%", nativeQuery = true)
    List<Product> findByKeyword(@Param("keyword") String keyword);
}