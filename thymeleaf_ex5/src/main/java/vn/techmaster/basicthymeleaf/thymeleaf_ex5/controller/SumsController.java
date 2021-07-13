package vn.techmaster.basicthymeleaf.thymeleaf_ex5.controller;

import lombok.extern.slf4j.Slf4j;
import vn.techmaster.basicthymeleaf.thymeleaf_ex5.model.calculate.CalculateRequest;
import vn.techmaster.basicthymeleaf.thymeleaf_ex5.model.calculate.CalculateResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("calculate")
public class SumsController {
    @GetMapping("math")
    public ModelAndView calculate(){
        ModelAndView mav = new ModelAndView("calculate");
        mav.addObject("calculate" , new CalculateRequest());
        mav.addObject("response" , null);
       return mav;
    }

    @PostMapping("math")
    public ModelAndView handleBMIForm(@ModelAttribute("calculate") CalculateRequest calculate, BindingResult bindingResult) {
        calculate.getX();
        calculate.getY();
        ModelAndView mav = new ModelAndView("calculate");
        if (! bindingResult.hasErrors()) {
            float sums = calculate.getX() + calculate.getY();
            CalculateResponse response = new CalculateResponse(sums);
            //
            mav.addObject("calculate", calculate);
            mav.addObject("response", response);
        }
        return mav; 
    }

}
