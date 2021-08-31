package com.codegym.model.repository;

import com.codegym.model.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
//    List<Product> findByNameProductContainingOrPriceBetween(@Param("name") String name, @Param("price1") String price1,
//                                                            @Param("price2") String price2);

    Product findByName(String name);
}
