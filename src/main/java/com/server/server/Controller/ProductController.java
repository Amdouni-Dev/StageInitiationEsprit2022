package com.server.server.Controller;

import com.server.server.Dto.ProductDto;
import com.server.server.Entity.Product;
import com.server.server.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import static com.server.server.Controller.PromotionController.*;

import java.util.List;
import java.util.stream.Collectors;


@RequestMapping("/oauth")
@RestController
public class ProductController {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  ProductService productService;

  @Autowired
  private ModelMapper modelMapper;

  HttpHeaders createHeaders() {
    return new HttpHeaders() {
      {
        String authHeader = "Bearer YjQwYWVhNTg2MWRhZmUwYjk4YWJlNzY5Y2Q1YjlkYjE5NzY1YTUwMzM2ZTM5NDM1Yjc3M2MzYmExNTI1OWE2Zg";
        set("Authorization", authHeader);
      }
    };

  }

  //get all promotions
  @GetMapping("/getProducts")
  public List<ProductDto> getProducts() {
    return productService.getProducts().stream().map(product -> modelMapper.map(product, ProductDto.class))
        .collect(Collectors.toList());
  }

  //get products paginated
  @GetMapping("/pagination/{offset}")
  public ResponseEntity<Page<Product>> getProductsPaginated(@PathVariable int offset){
    Page<Product> productPaginated = productService.getProductsWithPagination(offset);
    return new ResponseEntity<>(productPaginated, HttpStatus.OK);
  }

  //get product by id
  @GetMapping(value = "/getProduct/{id}")
  public ResponseEntity<Object> getProduct(@PathVariable("id") long id) {
    ResponseEntity<Product> product = productService.getProduct(id);
    if (product.getStatusCodeValue() == 200) {
      ProductDto productDto = modelMapper.map(product.getBody(), ProductDto.class);
      return new ResponseEntity<>(productDto, HttpStatus.OK);
    } else if (product.getStatusCodeValue() == 404) {
      return new ResponseEntity<>(NOT_FOUND, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(NULL, HttpStatus.OK);

    }

  }

  //update product
  @PutMapping(value = "/updateProduct/{id}")
  public ResponseEntity<Object> updateProduct(@PathVariable("id") long id, @RequestBody ProductDto productDto) {
    Product prodReq = modelMapper.map(productDto, Product.class);
    ResponseEntity<Product> product = productService.updateProduct(id, prodReq);

    if (product.getStatusCodeValue() == 200) {
      ProductDto prodRes = modelMapper.map(product.getBody(), ProductDto.class);
      return new ResponseEntity<>(prodRes, HttpStatus.OK);
    } else if (product.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
    } else if (product.getStatusCodeValue() == 404) {
      return new ResponseEntity<>(NOT_FOUND, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(NULL, HttpStatus.OK);
    }
  }


  // get Product by id-category
  @GetMapping(value = "/findProductByCategory_Id/{id_category}")
  public List<ProductDto> findProductByCategory_Id(@PathVariable("id_category") long id_category) {
    return productService.findProductByCategory_Id(id_category).stream().map(prod -> modelMapper.map(prod, ProductDto.class))
        .collect(Collectors.toList());
  }

  @GetMapping(value = "/findProductByName/{name}")
  public List<Product> FindProductByName(@PathVariable("name") String name)
  {
      return productService.getByKeyword(name);
  }



}
