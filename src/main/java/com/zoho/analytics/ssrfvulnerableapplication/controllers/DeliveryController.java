package com.zoho.analytics.ssrfvulnerableapplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Controller
public class DeliveryController {

    @GetMapping("/checkDeliveryLocation")
    @ResponseBody
    public String checkDeliveryLocation(
            @RequestParam("url") String url
    ) {
        // Here, you can implement the SSRF vulnerability check
        // If the provided URL contains "/admin" and the request comes from localhost,
        // redirect the user to the admin page
        RestTemplate restTemplate = new RestTemplate();

        // Make the request to the SSRF vulnerable URL

        // Check if the response contains the generated number (assuming the response format is known)
        try {
            String forObject = restTemplate.getForObject(url, String.class);
            return forObject;
        } catch (Exception e) {
            return "";
        }
    }

    @GetMapping("/isDeliverable")
    @ResponseBody
    public String isDeliverable() {
        boolean isDeliverable = new Random().nextBoolean();
        StringBuilder stringBuilder = new StringBuilder();
        if (isDeliverable) {
            stringBuilder.append("Yes");
        } else {
            stringBuilder.append("No");
        }
        stringBuilder.append(". The product ");
        if (isDeliverable) {
            stringBuilder.append("can");
        } else {
            stringBuilder.append("can't");
        }
        stringBuilder.append(" be delivered to this location.");
        return stringBuilder.toString();
    }
}