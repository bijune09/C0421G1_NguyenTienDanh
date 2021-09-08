package com.codegym.controller;

import com.codegym.model.bean.Cart;
import com.codegym.model.bean.Product;
import com.codegym.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ShoppingCartController {

    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }
//
//    @GetMapping("/delete/{id}")
//    public String removeProduct(@PathVariable long id,
//                                @SessionAttribute("cart") Cart cart){
//        Optional<Product> productOptional = productService.findById(id);
//        if (!productOptional.isPresent()){
//            return "error.404";
//        }
//        cart.removeProduct(productOptional.get());
//        return "redirect:/shopping-cart";
//    }
}