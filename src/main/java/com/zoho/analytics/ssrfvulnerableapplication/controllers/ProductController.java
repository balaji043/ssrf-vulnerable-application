package com.zoho.analytics.ssrfvulnerableapplication.controllers;

import com.zoho.analytics.ssrfvulnerableapplication.DataProvider;
import com.zoho.analytics.ssrfvulnerableapplication.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    @GetMapping("/product/{id}")
    public String productDescriptionPage(@PathVariable("id") int id, Model model) {
        Product product = getProductById(id);
        model.addAttribute("product", product);
        return "product";
    }


    private Product getProductById(int id) {
        // Retrieve product details from database or any other source
        // For demonstration purposes, we'll create a new Product object
        return DataProvider.getProductList().getProducts().stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }
}