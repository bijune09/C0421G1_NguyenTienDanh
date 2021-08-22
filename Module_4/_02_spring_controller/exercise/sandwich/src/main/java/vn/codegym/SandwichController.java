package vn.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String display(){
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("spice") String[] condiment , Model model){

        model.addAttribute("spice", Arrays.toString(condiment));
        return "index";
    }
}
