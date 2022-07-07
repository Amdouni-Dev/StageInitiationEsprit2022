package com.server.server.Controller;

import com.server.server.Dto.PanierDto;
import com.server.server.Dto.PromotionDto;
import com.server.server.Entity.Panier;
import com.server.server.Entity.Promotion;
import com.server.server.Service.PanierService;
import com.server.server.Service.PromotionService;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static com.server.server.Controller.PromotionController.NOT_FOUND;
import static com.server.server.Controller.PromotionController.NULL;

@RequestMapping("/oauth")
@RestController
public class PanierController {

    @Autowired
    private PanierService panierService;
    @Autowired
    private ModelMapper modelMapper;

    public PanierController(PanierService panierService) {
        super();
        this.panierService = panierService;
    }

    //get panier by id_client
    @GetMapping(value = "/findByIdClient/{id_client}")
    public ResponseEntity<Object> getByIdClient(@PathVariable("id_client") long id_client) {
        ResponseEntity<Panier> panier = panierService.findByClientId(id_client);
        if (panier.getStatusCodeValue() == 200) {

            PanierDto panierDto = modelMapper.map(panier.getBody(), PanierDto.class);
            return new ResponseEntity<>(panierDto, HttpStatus.OK);
        } else if(panier.getStatusCodeValue() == 404){
            return new ResponseEntity<>(NOT_FOUND,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(NULL,HttpStatus.OK);

        }
    }



}
