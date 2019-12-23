package krissto87.charity.controllers;

import krissto87.charity.dtos.RegistrationDataDTO;
import krissto87.charity.services.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "registration-form";
    }

    @PostMapping
    public String processRegistrationPage(@ModelAttribute("registrationData")
                                              @Valid RegistrationDataDTO registrationData,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return "registration-form";
        }
        registrationService.register(registrationData);
        return "redirect:/";
    }
}
