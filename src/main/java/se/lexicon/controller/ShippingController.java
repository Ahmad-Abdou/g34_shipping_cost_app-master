package se.lexicon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ShippingController {


    @GetMapping("/")
    public String addBoxForm(){
        return "AddBoxForm";
    }
    @GetMapping("/show/list")
    public String showBoxList(){
        return "ShowBoxList";
    }
    @GetMapping("/form")
    public String showingBox(Model model){

        return "ShowBoxList";

    }
    @PostMapping("/add/box")
    public String adding(){

        return "redirect:/ShowBoxList";
    }


}

