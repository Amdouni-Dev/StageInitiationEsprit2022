package com.server.server.Controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.server.Dto.ClientDto;
import com.server.server.Entity.Client;
import com.server.server.Payload.Response.JwtResponse;
import com.server.server.Repository.ClientRepository;
import com.server.server.Security.Jwt.JwtUtils;
import com.server.server.Security.Service.ClientDetails;
import com.server.server.Service.ClientService;


@RequestMapping("/oauth")
@RestController
public class ClientController {

  public final static String FOUND = "FOUND";
  public final static String BAD_REQUEST = "BAD_REQUEST";
  public final static String NOT_FOUND = "NOT_FOUND";
  public final static String NULL = "ID NULL DETECTED";

  @Autowired
  ClientService clientService;
  @Autowired
  ClientRepository clientRepository;
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/process_register")
  public ResponseEntity<Object> processRegister(@RequestBody ClientDto clientDto) throws UnsupportedEncodingException, MessagingException {
    Client clientReq = modelMapper.map(clientDto, Client.class);
    ResponseEntity<Client> client = clientService.register(clientReq);

    if (client.getStatusCodeValue() == 200) {
      ClientDto userRes = modelMapper.map(client.getBody(), ClientDto.class);
      return new ResponseEntity<>(userRes, HttpStatus.OK);
    } else if (client.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(FOUND, HttpStatus.OK);
    }
  }

  @GetMapping("/verify/{code}")
  public ResponseEntity<Object> verifyUser(@PathVariable String code) {
    ResponseEntity<Client> client = clientService.verify(code);
    if (client.getStatusCodeValue() == 200) {
      ClientDto usersDTO = modelMapper.map(client.getBody(), ClientDto.class);
      return new ResponseEntity<>(usersDTO, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(NOT_FOUND, HttpStatus.OK);
    }
  }

  @PostMapping("/signin")
  public ResponseEntity<Object> authenticateClient(@RequestBody ClientDto clientDto) {
    Client client = modelMapper.map(clientDto, Client.class);
    if (!clientService.existsEmail(client.getEmail())) {
      return new ResponseEntity<>(FOUND, HttpStatus.OK);
    }

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(client.getEmail(), client.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    ClientDetails clientDetails = (ClientDetails) authentication.getPrincipal();
    return new ResponseEntity<>(new JwtResponse(jwt,
        clientDetails.getId(),
        clientDetails.getEmail()
    ), HttpStatus.OK);
  }


  //get client by id
  @GetMapping(value = "/getClient/{id}")
  public ResponseEntity<Object> getClient(@PathVariable("id") long id) {
    ResponseEntity<Client> client = clientService.getClient(id);
    if (client.getStatusCodeValue() == 200) {
      ClientDto clientDto = modelMapper.map(client.getBody(), ClientDto.class);
      return new ResponseEntity<>(clientDto, HttpStatus.OK);
    } else if (client.getStatusCodeValue() == 404) {
      return new ResponseEntity<>(NOT_FOUND, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(NULL, HttpStatus.OK);

    }

  }
}
