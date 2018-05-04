package com.example.springtest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springtest.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
