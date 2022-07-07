package com.server.server.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Product;
@Repository

public interface ProductRepository extends JpaRepository<Product,Long> {


    void deleteProductByIdAndShoppingCart(long id_product,long id_shoppingcart);

}