package com.server.server.Controller.AdminController;

import com.server.server.Dto.ProductDto;
import com.server.server.Entity.Category;
import com.server.server.Entity.Orders;
import com.server.server.Entity.Product;
import com.server.server.Entity.ShoppingCart;
import com.server.server.Service.CategoryService;
import com.server.server.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

import static com.server.server.Controller.PromotionController.*;

@RequestMapping("/oauth")
@RestController
public class AdminPageController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    // En tant qu'admin je veux consulter ma page Home
    @GetMapping("/HomeAdmin")
    public ModelAndView viewHomePage1() {
        ModelAndView modelAndView = new ModelAndView("adminHome");
        return  modelAndView;
    }
    // En tant qu'admin je veux gerer les produits
    @GetMapping("/Admin_Products")
    public ModelAndView viewHomePage2(  RedirectAttributes redirAttrs) {
        redirAttrs.addFlashAttribute("success", "Liste des produits");


//
        ModelAndView modelAndView = new ModelAndView("products");
        List<Product> products=productService.findAll();
        modelAndView.addObject("list",products);
        return  modelAndView;
    }
    // En tant qu'admin je veux ajouter  un produit
    @PostMapping ("/Admin_ADD_Products")
    public ModelAndView viewHomePage3(@ModelAttribute("product") Product product) {
        List<Category> categories=categoryService.findAll();


        ModelAndView modelAndView = new ModelAndView("productsAdd");
        modelAndView.addObject("list",categories);
        productService.addProduct(product);
        System.out.println("*************************************"+categories);
        return  modelAndView;
    }

    @PostMapping("/saveProduct")
    public String saveProduct1(@ModelAttribute("product") Product product) {
        List<Category> categories=categoryService.findAll();
        System.out.println("*************************************"+categories);
        product.setCategories("ty");
      //  product.setActive(true);
        Date d=new Date();
        product.setDateUpd(d);
        product.setDateUpdDescription(d);
        product.setDateUpdImages(d);
        product.setDateUpd(d);
        product.setDateUpdStock(d);
        product.setDepth(1);
        product.setHeight(1);
        product.setInShopsPrice(1);
        product.setRetailPrice(1);
        product.setSku("2");
        product.setWeight(1);
        product.setWholesalePrice(1);
        product.setWidth(1);
        product.setCategory(new Category());
        product.setOrders(new Orders());
        product.setShoppingCart(new ShoppingCart());
        product.setIsoCode("12");

        product.setUrl("12");
        // save product to database
        productService.saveP(product);
        return "redirect:/";
    }

    @GetMapping("/showNewProductForm")
    public ModelAndView showNewProductForm() {
        ModelAndView modelAndView = new ModelAndView("productsAdd");
        // create model attribute to bind form data
        Product product = new Product();

        modelAndView.addObject("product",product);
        return  modelAndView;
    }


    // Update Product

    @GetMapping("/showFormForUpdate/{id}")
    public ModelAndView showFormForUpdate(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("formProductUpdate");

       Product product = productService.getProductById(id);


        modelAndView.addObject("product", product);
        return  modelAndView;
    }
    @PostMapping(value = "/updateProductA/{id}")
    public ModelAndView updateProduct(@PathVariable("id") long id) {
        Product prodReq = productService.getProductById(id);
        productService.updateProduct(id, prodReq);

        ModelAndView modelAndView = new ModelAndView("adminHome");
        modelAndView.addObject("product", prodReq);
        return modelAndView;
    }
    @PostMapping("/savePP")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product , RedirectAttributes redirAttrs) {
        ModelAndView modelAndView = new ModelAndView("products");
        productService.saveP(product);
        redirAttrs.addFlashAttribute("success", "Produit bien modifié.");
        return modelAndView;
    }
    @GetMapping("/deleteProduct/{id}")
    public ModelAndView deleteProduct(@PathVariable (value = "id") long id , RedirectAttributes redirAttrs) {


        productService.deleteProductById(id);
        ModelAndView modelAndView = new ModelAndView("adminHome");
        redirAttrs.addFlashAttribute("success", "Produit bien supprimé.");
        return modelAndView;
    }

}
