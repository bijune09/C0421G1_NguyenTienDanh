package com.codegym.model.repository;

import com.codegym.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllByCategory_CategoryName(String category, Pageable pageable);
    List<Blog> findAllByCategory_CategoryName(String category);
}
