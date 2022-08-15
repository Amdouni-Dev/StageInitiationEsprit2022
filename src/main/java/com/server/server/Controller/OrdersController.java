package com.server.server.Controller;

import com.server.server.Entity.Client;
import com.server.server.Entity.Orders;
import com.server.server.Repository.OrdersRepository;
import com.server.server.Service.OrdersService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

import static com.server.server.Controller.PromotionController.NOT_FOUND;

@RequestMapping("/oauth")
@RestController
public class OrdersController {
@Autowired
public OrdersService ordersService;
    @Autowired
    public OrdersRepository repo;



    // toutes les commandes
    @GetMapping(value = { "", "/Commandes" })
    public @NotNull Iterable<Orders> getCommandes() {
        return ordersService.getAllCommandes();}



//  test persoo
    @GetMapping(value = { "", "/IdsCommandes" })
    public @NotNull Iterable<String> getIdsCommandes() {
        return repo.findIdOrders();}

    // commande by id
    @GetMapping(value = { "", "/CommandeById/{id}" })
    public @NotNull List<Orders> getCommandeByID(@PathVariable("id") long id) {
        List<Orders> ors = repo.findOrdersById(id);
        return ors;
    }

    // Ajouter commande
    @PostMapping("/AjouterCommande")
    public Orders addNewOrder(@Valid @RequestBody Orders o) throws Exception {
        return ordersService.create(o);
    }





}
