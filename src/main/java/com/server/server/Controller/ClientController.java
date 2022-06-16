package com.server.server.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.server.server.Service.ClientService;

@RestController
public class ClientController {

  @Autowired
  ClientService clientService;

}
