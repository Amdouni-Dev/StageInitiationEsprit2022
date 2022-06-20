package com.server.server.Controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ProduitController {

  @Autowired
  private RestTemplate restTemplate;

  //get all products
  @GetMapping("/produits")
public List<Object> getProducts() {
    String url = "https://api.sandbox.bigbuy.eu/rest/catalog/productsinformation.json?isoCode=fr&pageSize=3&page=3";

   Object[] produits = restTemplate.getForObject(url, Object[].class);

    return  Arrays.asList(produits);

  }




}

