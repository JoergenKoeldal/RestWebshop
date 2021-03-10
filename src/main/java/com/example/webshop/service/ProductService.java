package com.example.webshop.service;

import com.example.webshop.model.Product;
import com.example.webshop.repository.ICrudRepository;
import com.example.webshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

//    public ProductService(ICrudRepository productRepository) {
//        this.productRepository = productRepository;
//
//    }

    public Product create(Product product) {
        return productRepository.create(product);
    }

    public void delete(long id) {
        productRepository.delete(id);
    }

    public void update(Product product) { productRepository.update(product);
    }

    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        for (Product product : productRepository.readAll()) {
            products.add(product);
        }
        return products;
    }

    public Product getProduct(long id) {
        return productRepository.getProduct(id);
    }
}
