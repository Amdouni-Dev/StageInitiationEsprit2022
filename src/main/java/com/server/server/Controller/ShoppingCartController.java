package com.server.server.Controller;

import com.server.server.Dto.ShoppingCartDto;
import com.server.server.Entity.ShoppingCart;
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

    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ModelMapper modelMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        super();
        this.shoppingCartService = shoppingCartService;
    }

    //get shopping_cart by id_client
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



}
