package krissto87.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RemindPasswordController {

    @GetMapping("/remind-password")
    public String prepareRemindPasswordPage() {
        return "remind-password";
    }
}
