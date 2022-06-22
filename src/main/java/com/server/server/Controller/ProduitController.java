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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ProduitController {

  @Autowired
  private RestTemplate restTemplate;


  HttpHeaders createHeaders(){
    return new HttpHeaders() {
      {
      String authHeader ="Bearer YjQwYWVhNTg2MWRhZmUwYjk4YWJlNzY5Y2Q1YjlkYjE5NzY1YTUwMzM2ZTM5NDM1Yjc3M2MzYmExNTI1OWE2Zg";
      set( "Authorization", authHeader );
      }
    };

  }

  //get product by id
  @RequestMapping(value = "/produit/{id}")
  public String getProductById(@PathVariable("id") long id) {
    return restTemplate.exchange("https://api.bigbuy.eu/rest/catalog/product/"+id +".json", HttpMethod.GET,new HttpEntity<String>(createHeaders()), String.class).getBody();
  }

  //get all products (specify page size and page)
  @GetMapping("/produits")
  public List<Object> getProducts(@RequestParam("isoCode") String isoCode, @RequestParam("pageSize") long pageSize, @RequestParam("page") long page) {
    String url ="https://api.bigbuy.eu/rest/catalog/productsinformation.json?isoCode="+isoCode+"&pageSize="+pageSize+"&page="+page;
    Object[] produits = restTemplate.exchange(url,HttpMethod.GET,new HttpEntity<String>(createHeaders()), Object[].class).getBody();
    return  Arrays.asList(produits);

  }

}

