package krissto87.charity.controllers;

import krissto87.charity.dtos.RegistrationDataDto;
import krissto87.charity.services.RegistrationService;
import krissto87.charity.services.VerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller @Slf4j
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
        model.addAttribute("registrationData", new RegistrationDataDto());
        return "registration-form";
    }

    @PostMapping("/registration")
    public String processRegistrationPage(@ModelAttribute("registrationData")
                                              @Valid RegistrationDataDto registrationData, BindingResult result) {
        if (result.hasErrors()) {
            return "registration-form";
        }
            registrationService.register(registrationData);
        return "finish-registration";
    }

    @RequestMapping("/confirm-account")
    public String confirmRegistration(@RequestParam("token") String tokenUrl) {
        if (tokenService.isTokenValidToActiveUser(tokenUrl).equals(false)) {
            return "activation-failed";
        }
        return "activation-complete";
    }
}

