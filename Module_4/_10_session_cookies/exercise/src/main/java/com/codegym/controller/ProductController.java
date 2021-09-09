package com.codegym.controller;

import com.codegym.model.bean.Cart;
import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping("/shop")
    public String showShop(Model model){
        model.addAttribute("products",productService.findAll());
        return "shop";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute Cart cart,@RequestParam("action") String action){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()){
            return "error.404";
        }

        if (action.equals("show")){
            cart.addProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("decrease")){
            cart.decreaseValue(productOptional.get());
            return "redirect:/shopping-cart";
        }
        if (action.equals("delete")){
            cart.removeProduct(productOptional.get());
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productOptional.get());
        return "redirect:/shop";
    }

//    @GetMapping("/delete/{id}")
//    public String removeProduct(RedirectAttributes redirectAttributes, @PathVariable long id,
//                                @SessionAttribute("cart") Cart cart){
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()){
//            return "error.404";
//        }
//        cart.removeProduct(productOptional.get());
//        return "redirect:/shopping-cart";
//    }

    @PostMapping("/shop")
    public String purchaseProduct(RedirectAttributes redirectAttributes,@SessionAttribute("cart") Cart cart){
        cart.purchaseProduct();
        redirectAttributes.addFlashAttribute("msg","Your purchase has been paid.\n" +
                "Thank you for your support ");
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable long id,Model model){
        Optional<Product> productOptional = this.productService.findById(id);
        if (!productOptional.isPresent()){
            return "error.404";
        }
        model.addAttribute("product",productOptional.get());
        return "detail";
    }
}
