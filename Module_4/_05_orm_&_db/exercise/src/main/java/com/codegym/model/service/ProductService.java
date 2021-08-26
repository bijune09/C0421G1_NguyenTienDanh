package com.codegym.model.service;

import com.codegym.model.bean.Product;
import com.codegym.model.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> selectAll() {
        return productRepository.selectAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Product product) {
        productRepository.remove(product);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }
}
