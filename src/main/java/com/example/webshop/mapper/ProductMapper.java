package com.example.webshop.mapper;

import com.example.webshop.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {


    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        int id = resultSet.getInt("productid");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        Product product = new Product(id, name, price);
        return product;

    }
}
