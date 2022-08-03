package com.server.server.Controller;

import com.server.server.Dto.CategoryDto;
import com.server.server.Dto.ProductDto;
import com.server.server.Entity.Category;
import com.server.server.Entity.Product;
import com.server.server.Service.CategoryService;
import com.server.server.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.server.server.Controller.PromotionController.NOT_FOUND;
import static com.server.server.Controller.PromotionController.NULL;

@RequestMapping("/oauth")
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;

    HttpHeaders createHeaders(){
        return new HttpHeaders() {
            {
                String authHeader ="Bearer YjQwYWVhNTg2MWRhZmUwYjk4YWJlNzY5Y2Q1YjlkYjE5NzY1YTUwMzM2ZTM5NDM1Yjc3M2MzYmExNTI1OWE2Zg";
                set( "Authorization", authHeader );
            }
        };

    }
    //get all categories
    @GetMapping("/getCategories")
    public List<CategoryDto> getCategories() {
        return categoryService.getCategories().stream().map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    //get category by id
    @GetMapping(value = "/getCategory/{id}")
    public ResponseEntity<Object> getCategory(@PathVariable("id") long id) {
        ResponseEntity<Category> category = categoryService.getCategory(id);
        if (category.getStatusCodeValue() == 200) {
            CategoryDto categoryDto = modelMapper.map(category.getBody(), CategoryDto.class);
            return new ResponseEntity<>(categoryDto, HttpStatus.OK);
        } else if (category.getStatusCodeValue() == 404) {
            return new ResponseEntity<>(NOT_FOUND, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(NULL, HttpStatus.OK);

        }

    }
}
