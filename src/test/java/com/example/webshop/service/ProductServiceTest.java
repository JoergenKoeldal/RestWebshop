package com.example.webshop.service;

import com.example.webshop.model.Product;
import com.example.webshop.repository.ICrudRepository;
import com.example.webshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

@SpringBootTest
class ProductServiceTest {

    private static final long product_id = 1;
    Product product;
    List<Product> productList = new ArrayList<>();

    //Initialise service to test with mocks - Will call upon the mock repository instead of the real one
    @InjectMocks
    ProductService productService;

    // Mocked repository that will return testdata
    @Mock
    ProductRepository mockedProductRepository;

    //Instantiate mock respository
    //Mockito 3.3.6 has to be openMocks - after you can explicist close it in an AfterEach
    //Before every test method, this is ran
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        product = new Product(product_id, "Ost", 20);
        Mockito.when(mockedProductRepository.getProduct(product_id)).thenReturn(product);
        Mockito.doNothing().when(mockedProductRepository).create(product);
        Mockito.doNothing().when(mockedProductRepository).delete(product_id);
        Mockito.doNothing().when(mockedProductRepository).update(product);
        Mockito.when(mockedProductRepository.readAll()).thenReturn(productList);

    }


    @Test
    void getProduct() {

        String name = productService.getProduct(product_id).getName();

        assertEquals("Ost", name);

        Mockito.verify(mockedProductRepository, times(1)).getProduct(product_id);

    }

    @Test
    void create() {

        productService.create(product);
        Mockito.verify(mockedProductRepository, times(1)).create(product);



    }

    @Test
    void delete() {
        productService.delete(product_id);
        Mockito.verify(mockedProductRepository, times(1)).delete(product_id);
    }

    @Test
    void update() {
        productService.update(product);
        Mockito.verify(mockedProductRepository, times(1)).update(product);

    }

    @Test
    void readAll() {
        productList = productService.readAll();
        Mockito.verify(mockedProductRepository, times(1)).readAll();


    }

    //    @Autowired
//    ProductService productService;
//    ProductService productService = new ProductService(new TestProductRepository());

//    @Test uden mocking
//    void readAll() {
//        List<Product> productList;
//        productList = productService.readAll();
//        long antal = productList.size();
//        assertEquals(1, antal);
//    }


}
