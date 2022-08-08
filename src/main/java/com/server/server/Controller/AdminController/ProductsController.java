package com.server.server.Controller.AdminController;

import com.server.server.Entity.Product;
import com.server.server.Repository.ProductRepository;
import com.server.server.Service.CategoryService;
import com.server.server.Service.ProductService;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsFileUploadSupport;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RequestMapping("/oauth")
@Controller
public class ProductsController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductRepository repo;
    // En tant qu'admin je veux consulter ma page Home
    @GetMapping("/HomeAdmin")
    public ModelAndView viewHomePage1() {
        ModelAndView modelAndView = new ModelAndView("adminHome");
        return  modelAndView;
    }

    @GetMapping("/oo")
    public String viewHomePage(Model model) {
        return findPaginated(1, "id", "asc", model);
    }
    // En tant qu'admin je veux ajouter  un produit
    @PostMapping("/Admin_ADD_Products")
    public ModelAndView viewHomePage3(@ModelAttribute("product") Product product) {

        productService.addProduct(product);
        ModelAndView modelAndView = new ModelAndView("productsAdd");

        return  modelAndView;
    }






    // En tant qu'admin je veux gerer les produits
    @GetMapping("/Admin_Products/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<Product> page = productService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Product> products = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("list", products);
        System.out.println("hi mouna");



        return "/layouts/produits";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public ModelAndView showFormForUpdate(@PathVariable(value = "id") long id) {
        ModelAndView modelAndView = new ModelAndView("layouts/updateProduct");

        Product product = productService.getProductById(id);

        modelAndView.addObject("categories", categoryService.findAll());
        modelAndView.addObject("product", product);
        return  modelAndView;
    }

    @GetMapping("/showNewProductForm")
    public String showNewProductForm(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "/layouts/newProduct";
    }




    @PostMapping("/savePP")
    public ModelAndView saveProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile multipartFile ) throws IOException {


        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setUrl(fileName);
        ModelAndView modelAndView = new ModelAndView("layouts/produits");
       Product p=  repo.save(product);
        String uploadDir = "product-photos/" + p.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return modelAndView;


    }

    @GetMapping("/deleteProduct/{id}")
    public ModelAndView deleteProduct(@PathVariable (value = "id") long id ) {


        productService.deleteProductById(id);
        ModelAndView modelAndView = new ModelAndView("/layouts/produits");

        return modelAndView;
    }

    @RequestMapping(path = {"/search","/search"})
    public String cherch(Product product, Model model, String keyword) {
        if(keyword!=null) {
            List<Product> list = productService.getByKeyword(keyword);
            model.addAttribute("list", list);
        }else {
            List<Product> list = productService.findAll();
            model.addAttribute("list", list);}
        return "/layouts/produits";
    }
}
