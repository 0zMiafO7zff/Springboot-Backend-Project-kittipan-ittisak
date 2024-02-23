package com.project.project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @Column(length = 6)
    private String p_id;

    @Column(length = 50)
    private String p_name;

    @Column(length = 2)
    private int p_category;

    @Column(length = 11)
    private int p_price;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ShoppingCart> shoppingCarts;

    public Product(String p_id, String p_name, int p_category, int p_price) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_category = p_category;
        this.p_price = p_price;
    }
}
