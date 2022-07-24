package com.server.server.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/oauth")
@RestController
public class HomeController {

    @GetMapping("/p")
    public ModelAndView viewHomePage3() {
        ModelAndView modelAndView = new ModelAndView("index");
        return  modelAndView;
    }
}
