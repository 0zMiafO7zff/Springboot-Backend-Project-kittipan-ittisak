package com.project.project.model;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sc_id;

    private Date sc_date;

    @ManyToOne
    @JoinColumn(name = "m_user")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private Product product;

    public ShoppingCart(Date sc_date, Member member, Product product) {

        this.sc_date = sc_date;
        this.member = member;
        this.product = product;
    }
}
