package com.codegym.model.repository;

import com.codegym.model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAll();
    void save(Product product);
    Product findById(int id);
    void remove(Product product);
    Product findByName(String name);
}
