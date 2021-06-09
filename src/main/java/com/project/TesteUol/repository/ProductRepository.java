package com.project.TesteUol.repository;

import com.project.TesteUol.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


    Optional<Product> findById(String id);
    @Query(value = "SELECT * FROM tb_products WHERE Product.id = :id ")
    default

    Optional<Product> findByProductUpdate(String name) {
        return null;
    }

    @Query("SELECT * FROM tb_products WHERE Product.name like :name ")
    default
    Optional<List<Product>> findByFilter() {
        return null;
    }

//  Optional<List<Product>> findByToday() {
//      return null;
//  }

}
