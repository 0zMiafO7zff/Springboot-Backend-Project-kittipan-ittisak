package com.project.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpInc;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.model.Product;
import com.project.project.model.ShoppingCart;
import com.project.project.repository.ProductRepository;
import com.project.project.repository.ShoppingCartRepository;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @GetMapping("")
    public Iterable<ShoppingCart> getAll() {
        return shoppingCartRepository.findAll();
    }

    @GetMapping("/{sc_id}")
    public Optional<ShoppingCart> getShopping(@PathVariable int sc_id){
        return shoppingCartRepository.findById(sc_id);
    }

    @PostMapping("/addShopping")
    public ShoppingCart addShopping(@RequestBody ShoppingCart shoppingCart){
        return shoppingCartRepository.save(shoppingCart);
    }

    @PutMapping("updateShopping/{sc_id}")
    public ShoppingCart updateShopping(@PathVariable int sc_id, @RequestBody ShoppingCart updateShopping){
        return shoppingCartRepository.findById(sc_id).map(shoppingCart -> {
            shoppingCart.setSc_date(updateShopping.getSc_date());
            shoppingCart.setMember(updateShopping.getMember());
            shoppingCart.setProduct(updateShopping.getProduct());
            return shoppingCartRepository.save(shoppingCart);
        })
        .orElseThrow(() -> new RuntimeException("Member not found with id " + sc_id));
    }

    @DeleteMapping("/deleteShopping/{sc_id}")
    public void deleteShopping(@PathVariable int sc_id) {
        shoppingCartRepository.deleteById(sc_id);
    }
}
