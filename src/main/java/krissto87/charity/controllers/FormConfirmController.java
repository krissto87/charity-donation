package krissto87.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormConfirmController {

    @RequestMapping("/donation/form-confirmation")
    public String processFormConfirmation() {
        return "user/form-confirmation";
    }
}
