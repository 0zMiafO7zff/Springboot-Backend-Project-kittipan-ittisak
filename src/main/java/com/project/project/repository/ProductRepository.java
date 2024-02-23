package com.project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.project.model.Product;

@RepositoryRestResource(path="product")
public interface ProductRepository extends JpaRepository<Product, String>{

}
