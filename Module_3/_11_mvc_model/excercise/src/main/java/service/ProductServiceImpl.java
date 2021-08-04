package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Iphone X", 500));
        productMap.put(2, new Product(2, "Nokia", 500));
        productMap.put(3, new Product(3, "SamSung", 500));
        productMap.put(4, new Product(4, "Black Berry", 500));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> search = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getName().equals(name)) {
                search.add(product);
                break;
            }
        }
        return search;
    }

}
