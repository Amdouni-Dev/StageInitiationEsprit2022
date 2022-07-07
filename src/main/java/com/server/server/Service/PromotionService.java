package com.server.server.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.server.server.Entity.Product;
import com.server.server.Entity.Promotion;
import com.server.server.Repository.ProductRepository;
import com.server.server.Repository.PromotionRepository;

@Service
public class PromotionService {
  @Autowired
  PromotionRepository promotionRepository;

  @Autowired
  ProductRepository productRepository;

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

  //create promo
  public ResponseEntity<Promotion> addPromotion(Promotion promotion) {
    if (promotion == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    promotion.setDateCreation(new Timestamp(System.currentTimeMillis()));
    Optional<Product> product = productRepository.findById(promotion.getProduct().getId());
    product.get().setPromotion(promotion);
    promotionRepository.save(promotion);
    return ResponseEntity.ok(promotion);

  }


  //update promo
  public ResponseEntity<Promotion> updatePromotion(long id, Promotion promotion) {

    if (promotion == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Optional<Promotion> optionalPromotion = promotionRepository.findById(id);

    if (optionalPromotion.isPresent()) {
      promotion.setId(id);
      promotion.setDateCreation(new Timestamp(System.currentTimeMillis()));
      promotionRepository.save(promotion);
      return ResponseEntity.ok(optionalPromotion.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


  //delete promo
  public void deletePromotion(long id) {
    promotionRepository.deleteById(id);
  }

}