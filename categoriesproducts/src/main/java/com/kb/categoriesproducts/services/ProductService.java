package com.kb.categoriesproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.categoriesproducts.models.Product;
import com.kb.categoriesproducts.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository prodRepo;

    

    public ProductService(ProductRepository prodRepo) {
        this.prodRepo = prodRepo;
    }

    public List<Product> allProducts(){
        return prodRepo.findAll();
    }

    public Product createProduct(Product product){
        return prodRepo.save(product);
    }

    public Product finProduct(Long id){
        Optional<Product> opProduct = prodRepo.findById(id);
        if (opProduct.isPresent()) {
            return opProduct.get();
        } else {
            return null;
        }
    }
    public Product updateProduct(Product product){
        return this.prodRepo.save(product);
    }
}
