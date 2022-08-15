package com.server.server.Service;

import com.server.server.Entity.Orders;
import com.server.server.Exception.ResourceNotFoundException;
import com.server.server.Repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Service
public class OrdersService  {
@Autowired
public OrdersRepository repo;

    public Iterable<Orders> getAllCommandes() {
        return repo.findAll();
    }


    public Orders getCommandeById(long id) {
        return repo
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commande not exist"));
    }


    public Orders create(Orders order) {
        order.setDateOrder(new Date());
        return this.repo.save(order);
    }

}
