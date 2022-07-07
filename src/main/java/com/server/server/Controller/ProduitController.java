package com.server.server.Controller;

import java.util.Arrays;
import java.util.List;

import com.server.server.Dto.ClientDto;
import com.server.server.Dto.ProduitDto;
import com.server.server.Entity.Client;
import com.server.server.Entity.Produit;
import com.server.server.Service.ClientService;
import com.server.server.Service.ProduitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import static com.server.server.Controller.PromotionController.NOT_FOUND;
import static com.server.server.Controller.PromotionController.NULL;


@RequestMapping("/oauth")
@RestController
public class ProduitController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  ProduitService produitService;

  @Autowired
  private ModelMapper modelMapper;
  HttpHeaders createHeaders(){
    return new HttpHeaders() {
      {
      String authHeader ="Bearer YjQwYWVhNTg2MWRhZmUwYjk4YWJlNzY5Y2Q1YjlkYjE5NzY1YTUwMzM2ZTM5NDM1Yjc3M2MzYmExNTI1OWE2Zg";
      set( "Authorization", authHeader );
      }
    };

  }
/*              ************************************************************************************
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

        ****************************************************************************************          */


  //get product by id
  @GetMapping(value = "/product/{id}")
  public ResponseEntity<Object> getProduct(@PathVariable("id") long id) {
    ResponseEntity<Produit> product = produitService.getProduct(id);
    if (product.getStatusCodeValue() == 200) {
      ProduitDto productDto = modelMapper.map(product.getBody(),ProduitDto.class);
      return new ResponseEntity<>(productDto, HttpStatus.OK);
    } else if (product.getStatusCodeValue() == 404) {
      return new ResponseEntity<>(NOT_FOUND, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(NULL, HttpStatus.OK);

    }

  }


  @DeleteMapping(value = "/deleteProduitByIdAndPanier/{id_produit}/{id_panier}")
  public  void deleteProduitByIdAndPanier(@PathVariable("id_produit") long id_produit, @PathVariable("id_panier") long id_panier) {
    produitService.deleteProduitByIdAndPanier(id_produit,id_panier);


  }

}

