package com.example.demo.model.service;

import com.example.demo.model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    void save(Product product);
    Product findById(int id);
    void remove(Product product);
    Product findByName(String name);
    List<Product> findByNameContainingAndCostBetween(String name,String price1,String price2);
}
