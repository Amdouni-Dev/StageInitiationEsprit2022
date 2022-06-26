package com.server.server.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.server.Entity.Client;
import com.server.server.Repository.ClientRepository;

@Service
public class ClientDetailsService implements UserDetailsService {

  @Autowired
  ClientRepository clientRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Client> client = clientRepository.findByEmail(username);
    if(client.isPresent())
      return ClientDetails.build(client.get());
    else
      return null;
  }
}
