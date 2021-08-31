package com.example.demo.model.repository;

import com.example.demo.model.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.websocket.server.PathParam;
import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContainingOrCostBetween(@PathParam("name") String name, @PathParam("price1") String price1,
                                                            @PathParam("price2") String price2);

    Product findByName(String name);
}
