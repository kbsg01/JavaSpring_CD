package com.kb.categoriesproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kb.categoriesproducts.models.Category;
import com.kb.categoriesproducts.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository catRepo;

    public CategoryService(CategoryRepository catRepo) {
        this.catRepo = catRepo;
    }

    public List<Category> allCategories(){
        return catRepo.findAll();
    }

    public Category createCat(Category category){
        return catRepo.save(category);
    }

    public Category findCategory(Long id){
        Optional<Category> opCategory = catRepo.findById(id);
        if (opCategory.isPresent()) {
            return opCategory.get();
        } else {
            return null;
        }
    }
    public Category updCategory(Category category){
        return this.catRepo.save(category);
    }
}
