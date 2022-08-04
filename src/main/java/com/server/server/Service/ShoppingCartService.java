package com.server.server.Service;

import com.server.server.Entity.Client;
import com.server.server.Entity.Product;
import com.server.server.Entity.Review;
import com.server.server.Entity.ShoppingCart;
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

    // get cart by id client
    public ResponseEntity<ShoppingCart> findByClientId(long id_client) {

        Optional<ShoppingCart> optionalShoppingCart = shoppingCartRepository.findByClientId(id_client);
        if (optionalShoppingCart.isPresent()) {
            return ResponseEntity.ok(optionalShoppingCart.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
