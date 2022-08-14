package com.server.server.Repository;

import com.server.server.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.server.server.Entity.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(value = "select * from category c join product p on c.id = p.category_id   ", nativeQuery = true)
    List<Category> findAllCategoriesNotEmpty();

}
