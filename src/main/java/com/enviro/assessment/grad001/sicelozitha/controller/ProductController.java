package com.enviro.assessment.grad001.sicelozitha.controller;

import com.enviro.assessment.grad001.sicelozitha.entity.Product;
import com.enviro.assessment.grad001.sicelozitha.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getProduct() {
        return productService.getInvestorProduct();
    }
}
