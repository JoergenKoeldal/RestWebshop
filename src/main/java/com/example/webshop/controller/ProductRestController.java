package com.example.webshop.controller;

import com.example.webshop.model.Product;
import com.example.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//Alle mine mapping bliver prependent med product
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getProduct() {
        return productService.readAll();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable("productId") int productId){
        return productService.getProduct(productId);
    }

    @PostMapping()
    //Herunder bliver produktet lavet til et objekt og fyldes ud med data fra Json
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        //Får vi productet tilbage med ID, efter ændring i repository create og service, som vi lige har oprettet
        Product productResponse = productService.create(product);
        //Her returneres en responseentity, der gør det muligt at definere Http statussen - som viser om man overholder reglerne for en rest controller.
        return new ResponseEntity<Product>(productResponse, HttpStatus.CREATED);

    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable("productId") int productId) {
        productService.delete(productId);
    }

    //Put mapping bruges til at ændre på et objekt
    @PutMapping("")
    //Herunder bliver produktet lavet til et objekt og fyldes ud med data fra Json
    public Product putProduct(@RequestBody Product product) {
        // Smid alt fra vores Json ned i en update metode og skift det man har ændret i produktet
        productService.update(product);
        return product;
    }







}
