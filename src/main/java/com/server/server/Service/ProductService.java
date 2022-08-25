package com.server.server.Service;

import com.server.server.Entity.*;
import com.server.server.Repository.ProductRepository;
import com.server.server.Repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShoppingCartRepository shoppinCartRepository;

    //get all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //get products paginated
    public Page<Product> getProductsWithPagination(int offset){
        Page<Product> productsPaginated = productRepository.findAll(PageRequest.of(offset, 10));
        return productsPaginated;
    }

    //get product by id
    public  ResponseEntity<Product> getProduct(long id) {

        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    //update promo
    public ResponseEntity<Product> updateProduct(long id, Product product) {

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            product.setId(id);
            productRepository.save(product);
            return ResponseEntity.ok(optionalProduct.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    public ResponseEntity<Product> addProduct(Product product) {
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productRepository.save(product);
        return ResponseEntity.ok(product);

    }
    public List<Product> findAll() {

        return productRepository.findAll();
    }
    public void saveP(Product product) {
        this.productRepository.save(product);
    }
    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

    // get product by id-category
    public List<Product> findProductByCategory_Id(long id_category) {

        return productRepository.findAllByCategoryId(id_category);

    }



    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.productRepository.findAll(pageable);
    }

    public Product getProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = null;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return product;
    }


    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }


    public List<Product> getByKeyword(String keyword){
        return productRepository.findByKeyword(keyword);
    }
}





