package com.codegym.controller;

import com.codegym.model.bean.Category;
import com.codegym.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showCategory(Model model){
        model.addAttribute(categoryService.findAll());
        return "category";
    }

    @GetMapping("/createCategory")
    public String showCreate(Model model){
        model.addAttribute("category",new Category());
        return "create-category";
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("msg","Success to create Category");
        return "redirect:/category";
    }

//    @GetMapping("/{id}/edit")
//    public String showEdit(Model model, @PathVariable int id){
//        model.addAttribute("category",categoryService.findById(id));
//        return "edit-category";
//    }
//
//    @PostMapping("/updateCategory")
//    public String updateCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
//        categoryService.save(category);
//        redirectAttributes.addFlashAttribute("msg","edit success");
//        return "redirect:/category";
//    }

}
