package com.example.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.ecommerce.dao.CategoryRepository;
import com.example.ecommerce.dao.ProductRepository;
import com.example.ecommerce.model.Category;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;

@Controller
public class HomeController {
	/* Autowired */
	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = { "/", "/home" })
	public String firstHomeView(Model m) {
		List<Product> products = this.productService.getProductsSortedByBuyCount();
		List<Category> categories = this.categoryService.getCategories();
		m.addAttribute("categories", categories);
		m.addAttribute("products", products);
		return "index";
	}


}