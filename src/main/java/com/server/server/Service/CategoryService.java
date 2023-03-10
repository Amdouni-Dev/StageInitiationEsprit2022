package com.server.server.Service;

import com.server.server.Entity.Category;
import com.server.server.Entity.Product;
import com.server.server.Repository.CategoryRepository;
import com.server.server.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

    //get all categs
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    //get by id
    public ResponseEntity<Category> getCategory(long id) {

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return ResponseEntity.ok(optionalCategory.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
