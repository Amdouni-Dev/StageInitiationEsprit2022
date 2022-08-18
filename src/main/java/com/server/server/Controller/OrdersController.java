package com.server.server.Controller;

import com.server.server.Entity.Client;
import com.server.server.Entity.Orders;
import com.server.server.Repository.ClientRepository;
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
    @Autowired
    public ClientRepository repoClient;



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

    // Mettre a jour commande
    @PostMapping("/UpdateCommande{id}")
    public Orders updateOrder(@Valid @RequestBody Orders o) throws Exception {
        return ordersService.create(o);
    }
// get client by commande

    @GetMapping("/getClientByCommandId/{id_commande}")
    public Client getClientBycommande(@PathVariable("id_commande") long id_commande){
        return repoClient.findClientByCommandID(id_commande);
    }

// get Command by client
    @GetMapping("/getCommandBylientId/{id_client}")
    public List<Orders> getCommandByClient(@PathVariable("id_client") long id_client){
        return repo.findCommandBylientID(id_client);
    }

// delete orders by id

    @DeleteMapping("/deleteCommandByIdC/{id}")
    public ResponseEntity<String> deleteByName(@PathVariable long id) {
        return new ResponseEntity<String>(repo.deleteOrdersById(id)+" Commande(s) supprimée(s)", HttpStatus.OK);
    }
// delete all orders by client id
    @DeleteMapping("/deleteCommandByClientId/{id}")
    public ResponseEntity<String> deleteCommandByClientId(@PathVariable long id) {
        return new ResponseEntity<String>(repo.deleteAllByClientId(id)+" Commande(s) supprimée(s)", HttpStatus.OK);
    }

// supprimer toutes les commandes 
    @DeleteMapping("/deleteAllOrderes")
    public ResponseEntity<String> deleteAllOrders() {
       repo.deleteAll() ;
        return new ResponseEntity<String>(" toute(s) les  Commande(s) sont  supprimée(s)", HttpStatus.OK);

    }

}
