package com.enviro.assessment.grad001.sicelozitha.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class WithdrawalNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long withdrawalId;
    private LocalDateTime timestamp;
    private double withdrawalAmount;
    // Add other fields as needed

    @ManyToOne
    private Investor investor;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    // Getters and setters

    public WithdrawalNotice() {
    }

    public WithdrawalNotice(LocalDateTime timestamp, double withdrawalAmount, Product product) {
        this.timestamp = timestamp;
        this.withdrawalAmount = withdrawalAmount;
        this.product = product;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Investor getInvestor() {
        return investor;
    }
}
