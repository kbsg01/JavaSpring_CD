package com.kb.categoriesproducts.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kb.categoriesproducts.models.Product;
import com.kb.categoriesproducts.services.ProductService;

@Controller
public class ProductController {
    private final ProductService prodService;

    public ProductController(ProductService prodService) {
        this.prodService = prodService;
    }

    @GetMapping("/products/new")
    public String createProduct(@ModelAttribute("product")Product product){
        return "newProduct";
    }
    @PostMapping("/products/new")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result){
        if (result.hasErrors()) {
            return "newProduct";
        } else {
            prodService.createProduct(product);
            return "redirect:/products/new";
        }
    } 
}
