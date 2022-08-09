package com.server.server.Controller.AdminController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import com.server.server.Service.ProductService;
@RequestMapping("/oauth")
@Controller
public class IndexCtrl {
	@Autowired
	private ProductService productService;
	@RequestMapping("/login")
	public String loginPage(){
		return "auth-login";
	}

	@RequestMapping("/home")
	public String loginSubmit(){
		return "/pages/landing_page";
	}

}
