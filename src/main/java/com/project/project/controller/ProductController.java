package com.project.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.project.model.Product;
import com.project.project.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{p_id}")
    public Optional<Product> getMemberById(@PathVariable String p_id) {
        return productRepository.findById(p_id);
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("updateProduct/{p_id}")
    public Product updateProduct(@PathVariable String p_id, @RequestBody Product updateProduct){
        return productRepository.findById(p_id).map(product -> {
            product.setP_name(updateProduct.getP_name());
            product.setP_category(updateProduct.getP_category());
            product.setP_price(updateProduct.getP_price());
            return productRepository.save(product);
        })
        .orElseThrow(()->new RuntimeException("Member not found with id "+ p_id));
    }

    @DeleteMapping("/deleteProduct/{p_id}")
    public void deleteProduct(@PathVariable String p_id){
        productRepository.deleteById(p_id);
    }
}

