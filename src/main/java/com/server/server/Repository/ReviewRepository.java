package com.server.server.Repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.server.server.Entity.Review;

import javax.transaction.Transactional;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Transactional
    @Modifying
    @Query("delete from Review r where r.product.id=:#{#id_product} AND r.client.id=:#{#id_client}")
    void deleteReviewByProductAndClient(@Param("id_product") long id_product, @Param("id_client") long id_client);


    @Transactional
    @Modifying
    @Query("delete from Review r where r.product.id=:#{#id_product}")
    void deleteReviewByProduct(@Param("id_product") long id_product);

    @Query("SELECT r FROM Review r WHERE r.client.id=:#{#id_client}")
    public Optional<Review> getReviewByClientId(@Param("id_client") long id_client);
    public Optional<Review> findByProduct_Id(long id_product);


    public Optional<Review> findByProduct_IdAndAndClient_Id(long id_product,long id_client);


}