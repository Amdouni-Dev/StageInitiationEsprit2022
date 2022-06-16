package com.server.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.server.Repository.ClientRepository;

@Service
public class ClientService {

  @Autowired
  ClientRepository clientRepository;

  //on va mettre les crud ici

}

