package com.server.server.Controller;


import com.server.server.Entity.Carriers;
import com.server.server.Service.CarriersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/oauth")
@RestController
public class CarriersController {

    private final CarriersService carriersService;

    public CarriersController(CarriersService carriersService) {
        this.carriersService = carriersService;
    }

    @GetMapping("/list")
    public Iterable<Carriers> list() {
        return carriersService.list();
    }


}
