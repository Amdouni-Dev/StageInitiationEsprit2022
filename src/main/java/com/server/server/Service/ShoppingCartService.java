
package com.server.server.Service;

import com.server.server.Entity.Client;
import com.server.server.Entity.Product;
import com.server.server.Entity.Review;
import com.server.server.Entity.ShoppingCart;
import com.server.server.Repository.ClientRepository;
import com.server.server.Repository.ProductRepository;
import com.server.server.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ProductRepository productRepository;
    // get cart by id client
    public ResponseEntity<ShoppingCart> findByClientId(long id_client) {

        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findByClientId(id_client);
        if (optionalShoppingCart.isPresent()) {
            return ResponseEntity.ok(optionalShoppingCart.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    // get Shopping cart by id-product and id_client

    public ResponseEntity<ShoppingCart> findByProductIdAndAndClientId(long id_product, long id_client) {

        Optional<ShoppingCart> optionalShoppingcart = shoppingCartRepository.findByProductIdAndAndClientId(id_product,id_client);

        if (optionalShoppingcart.isPresent()) {
            return ResponseEntity.ok(optionalShoppingcart.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // add product in shopping cart by a specify client
    public ResponseEntity<ShoppingCart> addProductInShoppingCartByClient(ShoppingCart shoppingCart, long id_product, long id_client) {
        if (shoppingCart == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Optional<Client> client = clientRepository.findById(id_client);
        Optional<Product> product = productRepository.findById(id_product);

        // set columns
        shoppingCart.setDate_adding_product(new Timestamp(System.currentTimeMillis()));
        shoppingCart.setProduct(product.get());
        shoppingCart.setClient(client.get());
        shoppingCart.setQuantity(shoppingCart.getQuantity()+1);

        shoppingCartRepository.save(shoppingCart);
        return ResponseEntity.ok(shoppingCart);

    }


    // delete  Product existing in shopping cart By id_product AND id_client
    public void deleteProductInShoppingCartByProductAndClient(long id_product,long id_client) {
        shoppingCartRepository.deleteShoppingCartByProductAndClient(id_product,id_client);
    }


    // + quantity




    // - quantity

}