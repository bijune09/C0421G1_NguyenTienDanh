package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.bean.contract.Contract;
import com.codegym.model.bean.contract.ContractDetail;
import com.codegym.model.service.contract.IAttachServiceService;
import com.codegym.model.service.contract.IContractDetailService;
import com.codegym.model.service.contract.IContractService;
import com.codegym.model.service.customer.ICustomerService;
import com.codegym.model.service.employee.IEmployeeService;
import com.codegym.model.service.service.IEntityServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/contracts")
public class ContractController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEntityServiceService serviceService;

    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @Autowired
    private IContractService contractService;



    @GetMapping
    public String contractPage(){
        return "/contract/home";
    }

    @GetMapping("/createContract")
    public String showCreateContract(Model model){
        model.addAttribute("contractDto",new ContractDto());
        model.addAttribute("employeeList",this.employeeService.findAllList());
        model.addAttribute("customerList",this.customerService.findAllList());
        model.addAttribute("serviceList",this.serviceService.findAll());
        return "/contract/create-contract";
    }

    @PostMapping("/createContract")
    public String createContract(@Valid @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult,
                                 Model model, RedirectAttributes rd){
        if (bindingResult.hasErrors()){
            model.addAttribute("employeeList",this.employeeService.findAllList());
            model.addAttribute("customerList",this.customerService.findAllList());
            model.addAttribute("serviceList",this.serviceService.findAll());
            return "/contract/create-contract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto,contract);
        this.contractService.save(contract);
        rd.addFlashAttribute("msg","Successfully.\nYou've created new Contract");
        return "redirect:/contracts";
    }

    @GetMapping("/createDetail")
    public String showCreateDetail(Model model){
        model.addAttribute("attachServiceList",this.attachServiceService.findAll());
        model.addAttribute("contractList",this.contractService.findAll());
        model.addAttribute("detailDto",new ContractDetailDto());
        return "/contract/create-detail";
    }

    @PostMapping("/createDetail")
    public String createDetail(@Valid @ModelAttribute("detailDto") ContractDetailDto contractDetailDto, BindingResult bindingResult,
                               Model model, RedirectAttributes rd){
        if (bindingResult.hasErrors()){
            model.addAttribute("attachServiceList",this.attachServiceService.findAll());
            model.addAttribute("contractList",this.contractService.findAll());
            return "/contract/create-detail";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        rd.addFlashAttribute("msg","Successfully.\nYou've created new Contract Detail");
        return "redirect:/contracts";
    }


}
