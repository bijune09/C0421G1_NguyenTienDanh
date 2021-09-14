package com.codegym.model.service;


import com.codegym.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(int id);

    void remove(int id);

    Page<Blog> findByCategory(String category, Pageable pageable);

    List<Blog> showAll();

    List<Blog> findBlogCategory(String category);
}
