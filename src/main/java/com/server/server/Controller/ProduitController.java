package com.server.server.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProduitController {

  //get all products
  @GetMapping("/produits")
public List<Object> getProducts() {
    String url = "https://api.sandbox.bigbuy.eu/rest/catalog/productsinformation.json";
    RestTemplate restTemplate = new RestTemplate();
    Object[] produits = restTemplate.getForObject(url, Object[].class);
    System.out.println(produits);
    return  Arrays.asList(produits);
  }

}
