package com.server.server.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.server.Dto.PromotionDto;
import com.server.server.Entity.Promotion;
import com.server.server.Service.PromotionService;

@RequestMapping("/oauth")
@RestController
public class PromotionController {

  public final static String FOUND = "FOUND";
  public final static String BAD_REQUEST = "BAD_REQUEST";
  public final static String NOT_FOUND = "NOT_FOUND";
  public final static String NULL = "ID NULL DETECTED";

  @Autowired
  private PromotionService promotionService;
  @Autowired
  private ModelMapper modelMapper;

  public PromotionController(PromotionService promotionService) {
    super();
    this.promotionService = promotionService;
  }

  //get all promotions
  @GetMapping("/promotions")
  public List<PromotionDto> getPromotions() {
    return promotionService.getPromotions().stream().map(promotion -> modelMapper.map(promotion, PromotionDto.class))
        .collect(Collectors.toList());
  }

  //get promo by id
  @GetMapping(value = "/promotion/{id}")
  public ResponseEntity<Object> getPromotion(@PathVariable("id") long id) {
    ResponseEntity<Promotion> promotion = promotionService.getPromotion(id);
    if (promotion.getStatusCodeValue() == 200) {
      PromotionDto promoDto = modelMapper.map(promotion.getBody(), PromotionDto.class);
      return new ResponseEntity<>(promoDto, HttpStatus.OK);
    } else if(promotion.getStatusCodeValue() == 404){
      return new ResponseEntity<>(NOT_FOUND,HttpStatus.OK);
    }else{
      return new ResponseEntity<>(NULL,HttpStatus.OK);

    }
  }

  //create promo to a specific produit
  @PostMapping("/addPromotion/{id_produit}")
  public ResponseEntity<Object> addPromotion(@RequestBody PromotionDto promotionDto,@PathVariable("id_produit") long id_produit) {
    Promotion promoReq = modelMapper.map(promotionDto, Promotion.class);
    ResponseEntity<Promotion> promotion = promotionService.addPromotion(promoReq,id_produit);
    if (promotion.getStatusCodeValue() == 200) {
      PromotionDto promotionRes = modelMapper.map(promotion.getBody(), PromotionDto.class);
      return new ResponseEntity<>(promotionRes, HttpStatus.OK);
    } else if (promotion.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
    }
  }

  //update promo
  @PutMapping(value = "/updatePromotion/{id}")
  public ResponseEntity<Object> updatePromotion(@PathVariable("id") long id, @RequestBody PromotionDto promotionDto) {
    Promotion promoReq = modelMapper.map(promotionDto, Promotion.class);
    ResponseEntity<Promotion> promotion = promotionService.updatePromotion(id,promoReq);

    if (promotion.getStatusCodeValue() == 200) {
      PromotionDto promoRes = modelMapper.map(promotion.getBody(), PromotionDto.class);
      return new ResponseEntity<>(promoRes, HttpStatus.OK);
    } else if (promotion.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
    } else if(promotion.getStatusCodeValue() == 404){
      return new ResponseEntity<>(NOT_FOUND,HttpStatus.OK);
    }else{
      return new ResponseEntity<>(NULL,HttpStatus.OK);
    }
  }

  //delete promo
  @DeleteMapping(value = "/deletePromotion/{id}")
  public void deletePromotion(@PathVariable("id") long id) {
    promotionService.deletePromotion(id);
  }

}
