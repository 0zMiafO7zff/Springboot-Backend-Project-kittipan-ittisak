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
public class Member {

    @Id
    @Column(length = 40)
    private String m_user;

    @Column(length = 60)
    private String m_name;

    @Column(length = 255)
    private String m_pass;

    @Column(length = 10)
    private String m_phone;

    private String m_role;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<ShoppingCart> shoppingCarts;
    public Member(String m_user, String m_name, String m_pass, String m_phone, String m_role) {
        this.m_user = m_user;
        this.m_name = m_name;
        this.m_pass = m_pass;
        this.m_phone = m_phone;
        this.m_role = m_role;
    }

}
