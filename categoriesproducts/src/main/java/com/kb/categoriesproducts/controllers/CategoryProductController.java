package com.kb.categoriesproducts.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kb.categoriesproducts.models.Category;
import com.kb.categoriesproducts.models.Product;
import com.kb.categoriesproducts.services.CategoryService;
import com.kb.categoriesproducts.services.ProductService;

@Controller
public class CategoryProductController {
    
    private final CategoryService catService;
    private final ProductService prodService;
    public CategoryProductController(CategoryService catService, ProductService prodService) {
        this.catService = catService;
        this.prodService = prodService;
    }

	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category cat = catService.findCategory(id);
		List<Product> catProds = cat.getProducts();
		List<Product> prods = prodService.allProducts();
		prods.removeIf(prod -> (catProds.contains(prod)));
		model.addAttribute("category", cat);
		model.addAttribute("products", prods);
		model.addAttribute("catProds", catProds);
		return "category";
	}

    @GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id, Model model) {
		Product prod = prodService.finProduct(id);
		List<Category> prodCats = prod.getCategories();
		List<Category> cats = catService.allCategories();
		cats.removeIf(cat -> (prodCats.contains(cat)));
		model.addAttribute("product", prod);
		model.addAttribute("categories", cats);
		model.addAttribute("prodCats", prodCats);
		return "product";
	}

    @PostMapping("/products/{id}/add")
    public String addCategory(@RequestParam("category") Long catId, @PathVariable("id") Long id){
        Category category = catService.findCategory(catId);
        category.addProduct(prodService.finProduct(id));
        catService.updCategory(category);
        return "redirect:/products/"+id;
    }
    
    @PostMapping("/categories/{id}/add")
    public String addProduct(@RequestParam("product")Long prodId, @PathVariable("id")Long id){
        Product product = prodService.finProduct(prodId);
        product.addCategory(catService.findCategory(id));
        prodService.updateProduct(product);
        return "redirect:/categories/"+id;
    }
}