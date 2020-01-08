package krissto87.charity.controllers;


import krissto87.charity.domain.entities.VerificationToken;
import krissto87.charity.dtos.RegistrationDataDTO;
import krissto87.charity.services.RegistrationService;
import krissto87.charity.services.UserService;
import krissto87.charity.services.VerificationTokenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;
    private final VerificationTokenService tokenService;


    public RegistrationController(RegistrationService registrationService,
                                  VerificationTokenService tokenService) {
        this.registrationService = registrationService;
        this.tokenService = tokenService;

    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "registration-form";
    }

    @PostMapping("/registration")
    public String processRegistrationPage(@ModelAttribute("registrationData")
                                              @Valid RegistrationDataDTO registrationData,
                                          BindingResult result) {
        if (result.hasErrors()) {
            return "registration-form";
        }
        registrationService.register(registrationData);
        return "finish-registration";
    }

    @RequestMapping("/confirm-account")
    public String confirmRegistration(@RequestParam("token") String tokenUrl) {
        if (tokenService.tokenValidity(tokenUrl).equals(false)) {
            return "activation-failed";
        }
        return "activation-complete";
    }
}
