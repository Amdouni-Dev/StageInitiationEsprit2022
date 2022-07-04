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

import com.server.server.Dto.AvisDto;
import com.server.server.Dto.PromotionDto;
import com.server.server.Entity.Avis;
import com.server.server.Entity.Promotion;
import com.server.server.Service.AvisService;
import com.server.server.Service.PromotionService;

@RequestMapping("/oauth")
@RestController
public class AvisController {

  public final static String FOUND = "FOUND";
  public final static String BAD_REQUEST = "BAD_REQUEST";
  public final static String NOT_FOUND = "NOT_FOUND";
  public final static String NULL = "ID NULL DETECTED";

  @Autowired
  private AvisService avisService;
  @Autowired
  private ModelMapper modelMapper;

  // insert a review
  @PostMapping("/addReview/{id_produit}/{id_client}")
  public ResponseEntity<Object> addReview(@RequestBody AvisDto avisDto, @PathVariable("id_produit") long id_produit, @PathVariable("id_client") long id_client) {
    Avis avisReq = modelMapper.map(avisDto,Avis.class);
    ResponseEntity<Avis> avis = avisService.addReview(avisReq,id_produit,id_client);
    if (avis.getStatusCodeValue() == 200) {
      AvisDto avisRes = modelMapper.map(avis.getBody(),AvisDto.class);
      return new ResponseEntity<>(avisRes, HttpStatus.OK);
    } else if (avis.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
    }
  }


//
  @DeleteMapping(value = "/deleteAvisByProduit/{id_produit}")
  public  void deleteAvisByProduit(@PathVariable("id_produit") long id_produit) {

    avisService.deleteAvisByProduit(id_produit);

  }

  @DeleteMapping(value = "/deleteAvisnew/{id_produit}/{id_client}")
  public  void deleteAvisBynew(@PathVariable("id_produit") long id_produit,@PathVariable("id_client") long id_client) {

    avisService.deleteAvisnew(id_produit,id_client);
  }


}
