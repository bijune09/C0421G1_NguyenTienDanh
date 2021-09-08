package com.codegym.model.service;

import com.codegym.model.bean.Product;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
    void remove(Long id);
}
