package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
