package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {


}
