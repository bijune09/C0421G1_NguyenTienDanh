package com.codegym.controller.customer;

import com.codegym.model.service.customer.ICustomerService;
import com.codegym.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public String showList(Model model, @PageableDefault(value = 5)Pageable pageable){
        model.addAttribute("customerList",this.customerService.findAll(pageable));
        return "customer/list";
    }
}
