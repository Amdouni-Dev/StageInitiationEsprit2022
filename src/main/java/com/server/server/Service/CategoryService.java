package com.server.server.Service;

import com.server.server.Entity.Category;
import com.server.server.Entity.Product;
import com.server.server.Repository.CategoryRepository;
import com.server.server.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> findAll() {

        return categoryRepository.findAll();
    }

}
