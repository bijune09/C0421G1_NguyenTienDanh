package com.codegym.controller;

import com.codegym.model.bean.Blog;
import com.codegym.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping(value = "")
    public String homePage(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "home";
    }

    @GetMapping(value = "/create")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "create";
    }

    @PostMapping(value = "/save")
    public String createBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes){
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("msg","Success");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEditForm(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "edit";
    }

    @PostMapping(value = "/update")
    public String editBlog(@ModelAttribute("blog") Blog blog,RedirectAttributes redirectAttributes){
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
    public String removeBlog(@ModelAttribute("blog") Blog blog,RedirectAttributes redirectAttributes){
        blogService.remove(blog.getId());
        redirectAttributes.addFlashAttribute("msg","Success");
        return "redirect:/";
    }

    @GetMapping(value = "/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "view";
    }
}
