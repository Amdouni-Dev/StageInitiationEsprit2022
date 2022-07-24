package com.server.server.Controller.AdminController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/oauth")
@RestController
public class AdminPageController {
    // En tant qu'admin je veux consuletr la liste es produits

    @GetMapping("/ListProduct")
    public ModelAndView viewHomePage3() {
        ModelAndView modelAndView = new ModelAndView("index");
        return  modelAndView;
    }
}
