package com.zoho.analytics.ssrfvulnerableapplication.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductList {
    ArrayList<Product> products;
    int total;
    int skip;
    int limit;
}
