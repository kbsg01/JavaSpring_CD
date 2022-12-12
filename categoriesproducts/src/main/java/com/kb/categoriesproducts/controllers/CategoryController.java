package com.kb.categoriesproducts.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kb.categoriesproducts.models.Category;
import com.kb.categoriesproducts.services.CategoryService;

@Controller
public class CategoryController {
    private final CategoryService catService;

    public CategoryController(CategoryService catService) {
        this.catService = catService;
    }

    @GetMapping("/categories/new")
    public String createCategory(@ModelAttribute("category")Category category){
        return "newCategory";
    }

    @PostMapping("/categories/new")
    public String createCategory(@Valid @ModelAttribute("category")Category category, BindingResult result){
        if (result.hasErrors()) {
            return "newCategory";
        } else {
            catService.createCat(category);
            return "redirect:/categories/new";
        }
    }
}
