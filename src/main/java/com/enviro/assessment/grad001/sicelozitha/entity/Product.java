package com.enviro.assessment.grad001.sicelozitha.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_currentBalance")
    private double currentBalance;
    @Column(name = "product_type")
    @Enumerated(EnumType.STRING)//map the enum to database
    private Type productType;

    @ManyToOne
    @JoinColumn(name = "investor_id")
    private Investor investor;
    // Getters and setters
    public Product() {
    }

    public Product(Type productType, String name, double currentBalance) {
        this.productType = productType;
        this.name = name;
        this.currentBalance = currentBalance;
    }

    public Type getType() {
        return productType;
    }

    public void setProductType(Type type) {
        this.productType = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }
}
