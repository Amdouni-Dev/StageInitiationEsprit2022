package com.server.server.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.server.server.Controller.ClientController;
import com.server.server.Entity.Avis;
import com.server.server.Entity.Client;
import com.server.server.Repository.AvisRepository;
import com.server.server.Repository.ClientRepository;


@Service
public class AvisService {
  @Autowired
  AvisRepository avisRepository;
  @Autowired
  ClientRepository clientRepository;

  //insert Review
  public ResponseEntity<Avis> addReview(Avis avis, long id_produit, long id_client) {
    if (avis == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Optional<Client> client = clientRepository.findById(id_client);

    // remplir les champs
    avis.setDate_creation(new Timestamp(System.currentTimeMillis()));
    avis.setId_produit(id_produit);
    avis.setClient(client.get());
    avisRepository.save(avis);
    return ResponseEntity.ok(avis);

  }

  // delete  review by idProduit

  public void deleteAvisByProduit(long id_produit) {
    avisRepository.deleteAvisByProduit(id_produit);
  }


 public void deleteAvisnew(long id_produit,long id_client) {
   avisRepository.deleteAvisnew(id_produit,id_client);
 }



}
