package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.model.Calculator;

@Controller
public class CalculatorController {
    @Autowired
    private Calculator calculator;

    @GetMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/calculator")
    public String result(@RequestParam("first") double first, @RequestParam("second") double second, @RequestParam("operator") String operator, Model model) {
        String result = "";
        try {
            result = String.valueOf(calculator.calculate(first,second,operator));
        } catch (Exception e){
            result = e.getMessage();
        }
        model.addAttribute("result",result);
        return "index";
    }
}
