package com.server.server.Repository;

import com.server.server.Entity.Category;
import com.server.server.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Orders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {


    @Query(value = "select c.email , c.country from orders o   join client c  on o.client_id = c.id   ", nativeQuery = true)
    List<String> findIdOrders();

    @Query(value = "SELECT * FROM orders o WHERE o.id LIKE %?1%", nativeQuery = true)
    List<Orders> findOrdersById(long id);

    @Override
    List<Orders> findAll();

    @Modifying(clearAutomatically = true)
    @Query("update Orders o set o.address =:address  where o.id =:id")
    void updateO(@Param("id") Long id, @Param("address") String address);


    @Query(value ="select * from orders o where o.client_id = ?1", nativeQuery = true)
    List<Orders> findCommandBylientID(@Param("id") Long id);





    @Transactional
    @Modifying
    @Query("DELETE FROM Orders WHERE id = :id")
    Integer deleteOrdersById(long id);


    @Transactional
    @Modifying
    @Query("DELETE FROM Orders WHERE client.id =  :id")
    Integer deleteAllByClientId(long id);

    @Override
    void deleteAll();
}
