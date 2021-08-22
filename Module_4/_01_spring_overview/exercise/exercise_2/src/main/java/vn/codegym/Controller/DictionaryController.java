package vn.codegym.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.codegym.model.IDictionary;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionary dictionary;

    @GetMapping(value = "")
    public String display(){
        return "index";
    }

    @PostMapping(value = "/dictionary")
    public String result(@RequestParam String word, Model model){
        model.addAttribute("result",dictionary.findWord(word));
        model.addAttribute("word",word);
        return "index";
    }
}
