package com.server.server.Service;

import com.server.server.Entity.Product;
import com.server.server.Entity.Promotion;
import com.server.server.Entity.Review;
import com.server.server.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //get all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //get product by id
    public  ResponseEntity<Product> getProduct(long id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    public Product getProductById(long id) {
        Optional < Product > optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return product;
    }

    //update promo
    public ResponseEntity<Product> updateProduct(long id, Product product) {

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            product.setId(id);
            productRepository.save(product);
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //delete product into cart
    public void deleteProductByIdAndShoppingCart(long id_product,long id_shoppingCart) {
        productRepository.deleteProductByIdAndShoppingCart(id_product,id_shoppingCart);
    }


    public ResponseEntity<Product> addProduct(Product product) {
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productRepository.save(product);
        return ResponseEntity.ok(product);

    }
    public List<Product> findAll() {

        return productRepository.findAll();
    }
    public void saveP(Product product) {
        this.productRepository.save(product);
    }
    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

    // get product by id-category
    public List<Product> findProductByCategory_Id(long id_category) {

        return productRepository.findAllByCategoryId(id_category);

    }
}





