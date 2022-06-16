package com.server.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  //on peut mettre des requettes ici (comme findBy...)

}

