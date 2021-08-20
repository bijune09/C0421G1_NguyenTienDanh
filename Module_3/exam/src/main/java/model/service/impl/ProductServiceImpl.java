package model.service.impl;

import model.bean.Product;
import model.repository.IProductRepository;
import model.repository.impl.ProductRepositoryImpl;
import model.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> selectAll() {
        return this.productRepository.selectAll();
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id);
    }

    @Override
    public void editProduct(Product product) {
        this.productRepository.editProduct(product);
    }

    @Override
    public void removeProduct(int id) {
        this.productRepository.removeProduct(id);
    }

    @Override
    public void createProduct(Product product) {
        this.productRepository.createProduct(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }
}
