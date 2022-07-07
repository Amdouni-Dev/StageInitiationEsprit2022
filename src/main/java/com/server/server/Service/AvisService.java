package com.server.server.Service;

import java.sql.Timestamp;
import java.util.Optional;

import com.server.server.Entity.Produit;
import com.server.server.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

  @Autowired
  ProduitRepository produitRepository;




  //insert Review ( for note and comment )
  public ResponseEntity<Avis> addReview(Avis avis, long id_produit, long id_client) {
    if (avis == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    Optional<Client> client = clientRepository.findById(id_client);
    Optional<Produit> produit = produitRepository.findById(id_produit);

    // set columns
    avis.setDate_creation(new Timestamp(System.currentTimeMillis()));
    avis.setProduit(produit.get());
    avis.setClient(client.get());
    avisRepository.save(avis);
    return ResponseEntity.ok(avis);

  }


  // delete  review by idProduit

  public void deleteAvisByProduit(long id_produit) {
    avisRepository.deleteAvisByProduit(id_produit);
  }

  // delete  review by idProduitANDidClient
  public void deleteAvisByProduitAndClient(long id_produit,long id_client) {
   avisRepository.deleteAvisByProduitAndClient(id_produit,id_client);
 }



}
