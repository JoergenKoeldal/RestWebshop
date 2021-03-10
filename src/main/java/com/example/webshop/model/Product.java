package com.example.webshop.model;

public class Product {
    private long productid;
    private String name;
    private double price;

    public Product(long productid, String name, double price) {
        this.productid = productid;
        this.name = name;
        this.price = price;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long id) {
        this.productid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
