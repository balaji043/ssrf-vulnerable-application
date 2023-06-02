package com.zoho.analytics.ssrfvulnerableapplication.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String adminPage(Model model) {
        // Generate a random number
        int randomNumber = (int) (Math.random() * 1000);

        // Add the generated number to the model
        model.addAttribute("number", randomNumber);

        return "admin";
    }
}