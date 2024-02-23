package com.project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.project.model.ShoppingCart;

@RepositoryRestResource(path="shoppingCart")
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{

}
