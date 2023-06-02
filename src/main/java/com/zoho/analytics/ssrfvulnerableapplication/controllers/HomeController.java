package com.zoho.analytics.ssrfvulnerableapplication.controllers;

import com.zoho.analytics.ssrfvulnerableapplication.DataProvider;
import com.zoho.analytics.ssrfvulnerableapplication.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model) {
        List<Product> productList = DataProvider.getProductList().getProducts();
        model.addAttribute("products", productList);
        return "home";
    }
}
