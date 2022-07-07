package com.server.server.Service;

import com.server.server.Entity.Client;
import com.server.server.Entity.Produit;
import com.server.server.Repository.ClientRepository;
import com.server.server.Repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProduitService {

    @Autowired
    ProduitRepository productRepository;



    //get product by id
    public  ResponseEntity<Produit> getProduct(long id) {

        Optional<Produit> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete product into cart

    public void deleteProduitByIdAndPanier(long id_produit,long id_panier) {
        productRepository.deleteProduitByIdAndPanier(id_produit,id_panier);
    }
}



