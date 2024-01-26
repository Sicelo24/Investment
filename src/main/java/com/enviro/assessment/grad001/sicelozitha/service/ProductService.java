package com.enviro.assessment.grad001.sicelozitha.service;

import com.enviro.assessment.grad001.sicelozitha.entity.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product>getInvestorProduct(long investorId);
    String withdrawAmount(long productId, double drawAmount);
}
