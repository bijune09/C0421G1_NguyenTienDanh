package com.codegym.controller.service;

import com.codegym.dto.ServiceDto;
import com.codegym.model.bean.service.Service;
import com.codegym.model.service.service.IEntityServiceService;
import com.codegym.model.service.service.IRentTypeService;
import com.codegym.model.service.service.IServiceTypeService;
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
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private IEntityServiceService entityServiceService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IServiceTypeService serviceTypeService;


    @GetMapping
    public String show(Model model){
//        model.addAttribute("serviceDto",new ServiceDto());
//        model.addAttribute("rentType",this.rentTypeService.findAll());
//        model.addAttribute("serviceType",this.serviceTypeService.findAll());
        return "service/list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("serviceDto",new ServiceDto());
        model.addAttribute("rentType",this.rentTypeService.findAll());
        model.addAttribute("listServiceType",this.serviceTypeService.findAll());
        return "service/create";
    }

    @PostMapping("/create")
    public String createService(@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto  , BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("rentType",this.rentTypeService.findAll());
            model.addAttribute("listServiceType",this.serviceTypeService.findAll());
            return "service/create";
        }
        Service service = new Service();
        BeanUtils.copyProperties(serviceDto,service);
        this.entityServiceService.save(service);
        redirectAttributes.addFlashAttribute("msg","Successfully.\n You have added a new service");
        return "redirect:/services";
    }
}
