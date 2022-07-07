package com.server.server.Service;

import com.server.server.Entity.Panier;
import com.server.server.Entity.Promotion;
import com.server.server.Repository.ClientRepository;
import com.server.server.Repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PanierService {

    @Autowired
    PanierRepository panierRepository;

    // get cart by id client
    public ResponseEntity<Panier> findByClientId(long id_client) {

        Optional<Panier> optionalPanier = panierRepository.findByClientId(id_client);
        System.out.println("ooooooooooooooooooooooo");
        if (optionalPanier.isPresent()) {
            return ResponseEntity.ok(optionalPanier.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
