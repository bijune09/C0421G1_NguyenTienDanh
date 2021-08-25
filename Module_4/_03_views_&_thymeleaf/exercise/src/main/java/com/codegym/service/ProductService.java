package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static Map<Integer,Product> integerProductMap;
    static {
        integerProductMap = new HashMap<>();
        integerProductMap.put(1,new Product(1,"iPhone X",599,"Màu hồng","Apple"));
        integerProductMap.put(2,new Product(2,"SamSung Fold",599,"Màu đỏ","SamSung"));
        integerProductMap.put(3,new Product(3,"Xiaomi Red Note",599,"Màu Xanh","Xiaomi"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(integerProductMap.values());
    }

    @Override
    public void save(Product product) {
        integerProductMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return integerProductMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        integerProductMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        integerProductMap.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product find : integerProductMap.values()){
            if (find.getName().equals(name)){
                return find;
            }
        }
        return null;
    }
}
