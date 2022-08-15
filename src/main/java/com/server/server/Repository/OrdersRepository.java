package com.server.server.Repository;

import com.server.server.Entity.Category;
import com.server.server.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Orders;

import java.util.List;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {


    @Query(value = "select c.email , c.country from orders o   join client c  on o.client_id = c.id   ", nativeQuery = true)
    List<String> findIdOrders();

    @Query(value = "SELECT * FROM orders o WHERE o.id LIKE %?1%", nativeQuery = true)
    List<Orders> findOrdersById(long id);

    @Override
    List<Orders> findAll();
}
