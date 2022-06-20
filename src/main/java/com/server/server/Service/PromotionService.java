package com.server.server.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.server.server.Entity.Promotion;
import com.server.server.Repository.PromotionRepository;

@Service
public class PromotionService {
  @Autowired
  PromotionRepository promotionRepository;

  //get all promo
  public List<Promotion> getPromotions() {
    return promotionRepository.findAll();
  }

  //get promo by id
  public ResponseEntity<Promotion> getPromotion(long id) {

    Optional<Promotion> optionalPromotion = promotionRepository.findById(id);
    if (optionalPromotion.isPresent()) {
      return ResponseEntity.ok(optionalPromotion.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


}
