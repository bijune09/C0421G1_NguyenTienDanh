package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.IBlogService;
import com.codegym.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping(value = "")
    public String homePage(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("blogList",blogService.findAll(pageable));
        return "home";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        model.addAttribute("categoryList",categoryService.findAll());
        return "create";
    }

    @PostMapping(value = "/save")
    public String createBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Create success");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEditForm(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        model.addAttribute("categoryList",categoryService.findAll());
        return "edit";
    }

    @PostMapping(value = "/update")
    public String editBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Success");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/delete")
    public String showDelete(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "delete";
    }

    @PostMapping(value = "/remove")
    public String removeBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("msg","Success");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "view";
    }

    @PostMapping(value = "/search")
    public String search(@RequestParam("search") String category, Model model,@PageableDefault(value = 5)Pageable pageable){
        model.addAttribute("blogList",blogService.findByCategory(category,pageable));
        return "home";
    }


}
