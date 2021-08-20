package vn.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping(value = "/")
    public String main(){
        return "convert";
    }


    @GetMapping(value = "/convert")
    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public String result(@RequestParam String usd, Model model){
        model.addAttribute("result",Double.parseDouble(usd)*23000);
        return "convert";
    }
}
