package com.server.server.Controller;

import com.server.server.Dto.ReviewDto;
import com.server.server.Dto.ShoppingCartDto;
import com.server.server.Entity.Review;
import com.server.server.Entity.ShoppingCart;
import com.server.server.Repository.ShoppingCartRepository;
import com.server.server.Service.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.server.server.Controller.PromotionController.NOT_FOUND;
import static com.server.server.Controller.PromotionController.NULL;

@RequestMapping("/oauth")
@RestController
public class ShoppingCartController {

    public final static String FOUND = "FOUND";
    public final static String BAD_REQUEST = "BAD_REQUEST";
    public final static String NOT_FOUND = "NOT_FOUND";
    public final static String NULL = "ID NULL DETECTED";

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ModelMapper modelMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        super();
        this.shoppingCartService = shoppingCartService;
    }

    //get shopping_cart by id_client
    // ************* A revoir
    @GetMapping(value = "/findByIdClient/{id_client}")
    public ResponseEntity<Object> getByIdClient(@PathVariable("id_client") long id_client) {
        ResponseEntity<ShoppingCart> shoppingCart = shoppingCartService.findByClientId(id_client);
        if (shoppingCart.getStatusCodeValue() == 200) {

            ShoppingCartDto shoppingCartDto =modelMapper.map(shoppingCart.getBody(), ShoppingCartDto.class);
            return new ResponseEntity<>(shoppingCartDto, HttpStatus.OK);
        } else if(shoppingCart.getStatusCodeValue() == 404){
            return new ResponseEntity<>(NOT_FOUND,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(NULL,HttpStatus.OK);

        }
    }

    // add product in shopping cart by a specify client
    @PostMapping("addProductInShoppingCartByClient/{id_product}/{id_client}")
    public ResponseEntity<Object> addProductInShoppingCartByClient(@RequestBody ShoppingCartDto shoppingCartDto, @PathVariable("id_product") long id_product, @PathVariable("id_client") long id_client) {
       ShoppingCart shoppingCartReq = modelMapper.map(shoppingCartDto,ShoppingCart.class);
        ResponseEntity<ShoppingCart> shoppingCart = shoppingCartService.addProductInShoppingCartByClient(shoppingCartReq,id_product,id_client);
        if (shoppingCart.getStatusCodeValue() == 200) {
            ReviewDto avisRes = modelMapper.map(shoppingCart.getBody(), ReviewDto.class);
            return new ResponseEntity<>(avisRes, HttpStatus.OK);
        } else if (shoppingCart.getStatusCodeValue() == 400) {
            return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
        }
    }


    // get Product by id-product and id_client
    @GetMapping(value = "/findByProductIdAndAndClientId/{id_product}/{id_client}")
    public ResponseEntity<Object>  findByProduct_IdAndAndClient_Id(@PathVariable("id_product") long id_product,@PathVariable("id_client") long id_client) {
        ResponseEntity<ShoppingCart> shoppingCartResponseEntity = shoppingCartService.findByProductIdAndAndClientId(id_product,id_client);
        if (shoppingCartResponseEntity.getStatusCodeValue() == 200) {
            ShoppingCartDto shoppingCartDto = modelMapper.map(shoppingCartResponseEntity.getBody(),ShoppingCartDto.class);
            return new ResponseEntity<>(shoppingCartDto,HttpStatus.OK);
        } else if (shoppingCartResponseEntity.getStatusCodeValue() == 404) {
            return new ResponseEntity<>(NOT_FOUND, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(NULL, HttpStatus.OK);

        }

    }

    // add product in shopping cart by a specify client
    @PostMapping("addProductInShoppingCartByClient/{id_product}/{id_client}")
    public ResponseEntity<Object> addProductInShoppingCartByClient(@RequestBody ShoppingCartDto shoppingCartDto, @PathVariable("id_product") long id_product, @PathVariable("id_client") long id_client) {
        ShoppingCart shoppingCartReq = modelMapper.map(shoppingCartDto,ShoppingCart.class);
        ResponseEntity<ShoppingCart> shoppingCart = shoppingCartService.addProductInShoppingCartByClient(shoppingCartReq,id_product,id_client);
        if (shoppingCart.getStatusCodeValue() == 200) {
            ShoppingCartDto shoppingCartRes = modelMapper.map(shoppingCart.getBody(), ShoppingCartDto.class);
            return new ResponseEntity<>(shoppingCartRes, HttpStatus.OK);
        } else if (shoppingCart.getStatusCodeValue() == 400) {
            return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
        }
    }


    // delete  Product existing in shopping cart By id_product AND id_client
    @DeleteMapping(value = "/deleteProductInShoppingCartByProductAndClient/{id_product}/{id_client}")
    public  void deleteProductInShoppingCartByProductAndClient(@PathVariable("id_product") long id_product,@PathVariable("id_client") long id_client) {

        shoppingCartService.deleteProductInShoppingCartByProductAndClient(id_product,id_client);
    }


    // delete  Product existing in shopping cart By id_product AND id_client
    @DeleteMapping(value = "/deleteProductInShoppingCartByProductAndClient/{id_product}/{id_client}")
    public  void deleteProductInShoppingCartByProductAndClient(@PathVariable("id_product") long id_product,@PathVariable("id_client") long id_client) {

        shoppingCartService.deleteProductInShoppingCartByProductAndClient(id_product,id_client);
    }



    //Increment Quantity Product
/*
    @PostMapping("IncrementQuantityProduct/{id_product}/{id_client}")
    public ResponseEntity<Object> IncrementQuantityProduct(@RequestBody ShoppingCartDto shoppingCartDto, @PathVariable("id_product") long id_product, @PathVariable("id_client") long id_client) {
        ShoppingCart shoppingCartReq = modelMapper.map(shoppingCartDto,ShoppingCart.class);
        ResponseEntity<ShoppingCart> shoppingCart = shoppingCartService.IncrementQuantityProduct(id_product,id_client);
        if (shoppingCart.getStatusCodeValue() == 200) {
            ShoppingCartDto shoppingCartRes = modelMapper.map(shoppingCart.getBody(), ShoppingCartDto.class);
            return new ResponseEntity<>(shoppingCartRes, HttpStatus.OK);
        } else if (shoppingCart.getStatusCodeValue() == 400) {
            return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(FOUND, HttpStatus.FOUND);
        }
    }


*/








}