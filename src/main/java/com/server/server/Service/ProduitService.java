package com.server.server.Service;

import com.server.server.Entity.Produit;

import com.server.server.Repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    public Iterable<Produit> list() {
        return produitRepository.findAll();
    }

    public Produit save(Produit produit) {
        return produitRepository.save(produit);
    }

    public void save(List<Produit> produits) {
        produitRepository.saveAll(produits);
    }

}
