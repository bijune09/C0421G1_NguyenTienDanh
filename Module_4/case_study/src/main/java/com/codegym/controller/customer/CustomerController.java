package com.codegym.controller.customer;

import com.codegym.dto.CustomerDto;
import com.codegym.model.bean.customer.Customer;
import com.codegym.model.service.customer.ICustomerService;
import com.codegym.model.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public String showList(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("customerList", this.customerService.findAll(pageable));
        return "customer/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerType", this.customerTypeService.findAll());
        return "customer/create";
    }

    @PostMapping("/create")
    public String createCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto,
                                 BindingResult bindingResult, Model model,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", this.customerTypeService.findAll());
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Successfully!!\n You have create new Customer");
        return "redirect:/customers";
    }

    @GetMapping(value = "/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("customerDto",this.customerService.findById(id));
        model.addAttribute("customerType", this.customerTypeService.findAll());
        return "customer/edit";
    }

    @PostMapping("/update")
    public String editCustomer(@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult,
                               Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerType", this.customerTypeService.findAll());
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("msg", "Successfully!!" +
                "\n You've changed " + customerDto.getName());
        return "redirect:/customers";
    }

    @GetMapping("/remove")
    public String removeCustomer(@RequestParam("id") Long id,RedirectAttributes redirectAttributes){
        this.customerService.remove(id);
        redirectAttributes.addFlashAttribute("msg","You've removed customer");
        return "redirect:/customers";
    }


}
