package com.example.webshop.repository;

import com.example.webshop.mapper.ProductMapper;
import com.example.webshop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;



@Repository
public class ProductRepository implements ICrudRepository<Product> {

    private final ProductMapper productMapper = new ProductMapper();

    @Autowired
    JdbcTemplate template;

    @Override
    public Product create(Product product) {
        String sql = "INSERT INTO products (name, price) VALUES (?,?)";
        template.update(sql, product.getName(), product.getPrice());
        int newUserId = template.queryForObject("SELECT last_insert_id() as id", (rs, i) -> rs.getInt("id"));
        return getProduct(newUserId);
    }

    @Override
    public List<Product> readAll() {
        String sql = "SELECT * FROM products";
        return template.query(sql, productMapper);
    }

    @Override
    public Product getProduct(long productid) {
        String sql = "SELECT * FROM products WHERE productid=?";
        return template.queryForObject(sql, productMapper, productid);
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET name=?, price=? WHERE productid=?";
        template.update(sql, product.getName(), product.getPrice(), product.getProductid());
    }

    @Override
    public void delete(long productid) {
        String sql = "DELETE FROM products WHERE productid=?";
        template.update(sql, productid);
    }
}
