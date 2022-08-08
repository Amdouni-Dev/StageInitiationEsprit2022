package com.server.server.Controller.AdminController;

import javax.validation.Valid;

import com.server.server.Entity.Employee;
import com.server.server.Entity.Product;
import com.server.server.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
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
		return "/layouts/dashboard";
	}

}
