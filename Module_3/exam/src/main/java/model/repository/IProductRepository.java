package model.repository;

import model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> selectAll();
    Product findById(int id);
    void editProduct(Product product);
    void removeProduct(int id);
    void createProduct(Product product);
    List<Product> findByName(String name);
}
