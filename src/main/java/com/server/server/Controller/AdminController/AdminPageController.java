package com.server.server.Controller.AdminController;

import com.server.server.Entity.Product;
import com.server.server.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/oauth")
@RestController
public class AdminPageController {
    @Autowired
    private ProductService productService;
    // En tant qu'admin je veux consulter ma page Home
    @GetMapping("/HomeAdmin")
    public ModelAndView viewHomePage1() {
        ModelAndView modelAndView = new ModelAndView("adminHome");
        return  modelAndView;
    }
    // En tant qu'admin je veux gerer les produits
    @GetMapping("/Admin_Products")
    public ModelAndView viewHomePage2() {


        ModelAndView modelAndView = new ModelAndView("products");
        List<Product> products=productService.findAll();
        modelAndView.addObject("list",products);
        return  modelAndView;
    }
    // En tant qu'admin je veux ajouter  un produit
    @PostMapping ("/Admin_ADD_Products")
    public ModelAndView viewHomePage3(@ModelAttribute("product") Product product) {

        productService.addProduct(product);
        ModelAndView modelAndView = new ModelAndView("productsAdd");

        return  modelAndView;
    }

    @PostMapping("/saveProduct")
    public String saveEmployee(@ModelAttribute("product") Product product) {
        // save employee to database
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/showNewProductForm")
    public ModelAndView showNewEmployeeForm() {
        ModelAndView modelAndView = new ModelAndView("productsAdd");
        // create model attribute to bind form data
        Product product = new Product();
        modelAndView.addObject("product",product);
        return  modelAndView;
    }

}
