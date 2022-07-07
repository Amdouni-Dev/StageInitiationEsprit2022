package com.server.server.Service;

import com.server.server.Entity.Product;
import com.server.server.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;



    //get product by id
    public  ResponseEntity<Product> getProduct(long id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete product into cart

    public void deleteProductByIdAndShoppingCart(long id_product,long id_shoppingCart) {
        productRepository.deleteProductByIdAndShoppingCart(id_product,id_shoppingCart);
    }
}



