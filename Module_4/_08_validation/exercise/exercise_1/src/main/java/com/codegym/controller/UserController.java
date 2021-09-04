package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.bean.User;
import com.codegym.model.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "create";
    }

    @PostMapping("/save")
    public String saveUser(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto,user);
            userService.save(user);
            return "result";
        }
    }
}
