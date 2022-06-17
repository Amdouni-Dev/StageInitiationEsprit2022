package com.server.server.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {
  @Override
  List<Promotion> findAll();

}