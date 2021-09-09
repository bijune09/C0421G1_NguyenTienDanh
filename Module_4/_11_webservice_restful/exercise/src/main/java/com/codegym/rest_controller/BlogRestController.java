package com.codegym.rest_controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/blog/api")
public class BlogRestController {
//    Xem danh sách các category
//    Xem danh sách các bài viết
//    Xem danh sách các bài viết của một category
//    Xem chi tiết một bài viết


    @Autowired
    private IBlogService blogService;

    @GetMapping()
    public ResponseEntity<List<Blog>> showList() {
        List<Blog> blogList = blogService.showAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showDetail(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if (blog==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Blog>> searchBlog(@RequestParam String category){
        List<Blog> blogList = blogService.findBlogCategory(category);
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }
}
