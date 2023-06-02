package com.zoho.analytics.ssrfvulnerableapplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zoho.analytics.ssrfvulnerableapplication.models.ProductList;
import org.springframework.util.ResourceUtils;

import java.io.File;

public class DataProvider {
    private DataProvider() {
    }

    private static ProductList productList;

    public static ProductList getProductList() {
        if (productList == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = null;
            try {
                file = ResourceUtils.getFile("classpath:data/products.json");
                productList = objectMapper.readValue(file, ProductList.class);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return productList;
    }

}
