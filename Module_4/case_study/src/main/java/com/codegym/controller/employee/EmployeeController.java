package com.codegym.controller.employee;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.bean.employee.Employee;
import com.codegym.model.repository.employee.IPositionRepository;
import com.codegym.model.service.employee.IDivisionService;
import com.codegym.model.service.employee.IEducationService;
import com.codegym.model.service.employee.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IEducationService educationService;

    @Autowired
    private IPositionRepository positionRepository;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping
    public String showList(Model model, @PageableDefault(value = 5) Pageable pageable) {
        model.addAttribute("employeeList", this.employeeService.findAll(pageable));
        return "/employee/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        model.addAttribute("divisionList", this.divisionService.findAll());
        model.addAttribute("educationList", this.educationService.findAll());
        model.addAttribute("positionList", this.positionRepository.findAll());
        return "/employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult,
                                 Model model, RedirectAttributes rd) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisionList", this.divisionService.findAll());
            model.addAttribute("educationList", this.educationService.findAll());
            model.addAttribute("positionList", this.positionRepository.findAll());
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);
        rd.addFlashAttribute("msg", "Successfully.\n You have create new Employee");
        return "redirect:/employees";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        model.addAttribute("divisionList", this.divisionService.findAll());
        model.addAttribute("educationList", this.educationService.findAll());
        model.addAttribute("positionList", this.positionRepository.findAll());
        model.addAttribute("employeeDto", this.employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/update")
    public String editEmployee(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult,
                               Model model, RedirectAttributes rd) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("divisionList", this.divisionService.findAll());
            model.addAttribute("educationList", this.educationService.findAll());
            model.addAttribute("positionList", this.positionRepository.findAll());
            return "/employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        this.employeeService.save(employee);
        rd.addFlashAttribute("msg", "Successfully.\n You have changed Employee" + employeeDto.getName());
        return "redirect:/employees";
    }

    @GetMapping("/search")
    public String searchByName(@RequestParam("name")String name,@PageableDefault(value = 5) Pageable pageable,
                               Model model){
        Page<Employee> employee = this.employeeService.findByName(name,pageable);
        if (employee.isEmpty()){
            return "error";
        }
        model.addAttribute("employeeList",employee);
        return "employee/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id,RedirectAttributes redirectAttributes){
        this.employeeService.remove(id);
        redirectAttributes.addFlashAttribute("msg","xoa r");
        return "redirect:/employees";
    }
}
