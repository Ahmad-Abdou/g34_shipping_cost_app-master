package se.lexicon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import se.lexicon.entity.Box;
import se.lexicon.repositroy.BoxRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ShippingController {

    BoxRepository boxRepository;

    @Autowired
    public void setBoxRepository(BoxRepository boxRepository) {
        this.boxRepository = boxRepository;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        Iterable<Box> iterable = boxRepository.findAll();
        List<Box> boxList = new ArrayList<>();
        iterable.iterator().forEachRemaining(boxList::add);
        model.addAttribute("boxList", boxList);
        return "showBoxList";
    }
    @GetMapping("/")
    public String registerForm(Model model) {
        Box box = new Box();
        model.addAttribute("box", box);
        return "addBoxForm";
    }

    @PostMapping("/add")
    public String add( @ModelAttribute("box") Box box ) {

        boxRepository.save(box);
        System.out.println("box = " + box);
        return "redirect:/list";
    }


}

