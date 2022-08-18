package com.server.server.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

  @Query("SELECT c FROM Client c WHERE c.email = ?1")
  public Optional<Client> findByEmail(String email);

  @Query("SELECT c FROM Client c WHERE c.verificationCode = ?1")
  public Optional<Client> findByVerificationCode(String code);


  boolean existsByEmail(String email);


  @Query(value ="select * from client c join orders o on c.id=o.client_id group by ?1", nativeQuery = true)
  Client findClientByCommandID(@Param("id") Long id);
}

