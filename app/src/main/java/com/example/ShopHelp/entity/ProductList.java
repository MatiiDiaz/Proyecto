package com.example.ShopHelp.entity;

import java.util.ArrayList;

public class ProductList {
    private String name;
    private ArrayList<Product> shopping;
    private int amount;
    public ProductList(String name, int amount){
        this.name = name;
        this.amount = amount;
        this.shopping = new ArrayList<>();
    }
    public boolean addProduct(Product newProduct){
        return true;
    }
    public boolean deleteProduct(Product newProduct){
        return true;
    }
}
