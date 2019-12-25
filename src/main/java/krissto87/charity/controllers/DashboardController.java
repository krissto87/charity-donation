package krissto87.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class DashboardController {

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/admin/admin-homepage");
        return model;
    }

    @GetMapping("/user")
    public ModelAndView user() {
        ModelAndView model = new ModelAndView();
        model.setViewName("/user/user-homepage");
        return model;
    }

}