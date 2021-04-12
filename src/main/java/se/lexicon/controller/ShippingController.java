package se.lexicon.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ShippingController {


    @GetMapping("/form")
    public String addBoxForm(){

        return "AddBoxForm";
    }

    @GetMapping("show/list")
    public String showBoxList(){

        return "ShowBoxList";
    }
}

