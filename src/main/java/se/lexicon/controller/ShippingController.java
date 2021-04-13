package se.lexicon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se.lexicon.entity.Box;
import se.lexicon.repositroy.BoxRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShippingController {

    BoxRepository boxRepository;
    List<Box> boxList = new ArrayList<>();
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
    public String add(@ModelAttribute("box") @Valid Box box, BindingResult bindingResult, RedirectAttributes redirectAttributes ) {
        if(box.getName().length() < 4 || box.getName().length()>20 ){
            FieldError fieldError = new FieldError("box","name","Name must be between 4 and 20 character");
            bindingResult.addError(fieldError);
        }
        if(box.getType() ==null ){
            FieldError fieldError = new FieldError("box","type","Type Can't be null");
            bindingResult.addError(fieldError);
        }
        if(box.getWeight() < 1 ){
            FieldError fieldError = new FieldError("box","weight","Weight should not be less than 1");
            bindingResult.addError(fieldError);
        }
        if(box.getWeightType() == null ){
            FieldError fieldError = new FieldError("box","weight type","Choose Your weight type");
            bindingResult.addError(fieldError);
        }
        if(box.getCountry().equals(null) || box.getCountry().length()==0 ){
            FieldError fieldError = new FieldError("box","country","Country can't be null");
            bindingResult.addError(fieldError);
        }

        if (bindingResult.hasErrors()) {
            return "addBoxForm";
        }
        box.setCost(calculatingCost(box));
        box.setCreateDate(LocalDateTime.now());
        box.setStatus(true);
        boxRepository.save(box);

        redirectAttributes.addFlashAttribute("message", "Operation is Done. Tracking Code:"+box.getId());
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        System.out.println("box = " + box);
        return "redirect:/list";
    }

    public double calculatingCost(Box box){
        double cost = 0.0;
        if(box == null) throw new NullPointerException ("Invalid data!");
         if(box.getCountry().equals("Sweden")  && box.getWeightType().equals("KG") ){
            cost=  box.getWeight()*(2.5)*1000;
        }
        else if(box.getCountry().equals("Sweden") && box.getWeightType().equals("G")){
            cost=  box.getWeight()*(2.5)*2;
        }

        if(box.getCountry().equals("Sweden") && box.getWeightType().equals("KG")){
            cost=  box.getWeight()*(7.0)*1000;
        }
        else if(box.getCountry().equals("Sweden") && box.getWeightType().equals("G")){
            cost=  box.getWeight()*(7.0)*2;
        }

        return cost;
    }

}

