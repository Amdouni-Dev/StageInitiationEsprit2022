package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
