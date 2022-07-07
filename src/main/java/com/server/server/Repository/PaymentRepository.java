package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
