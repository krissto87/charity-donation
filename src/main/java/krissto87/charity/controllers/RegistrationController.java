package krissto87.charity.controllers;

import krissto87.charity.dtos.RegistrationDataDTO;
import krissto87.charity.services.RegistrationService;
import krissto87.charity.services.VerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
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
        try {
            registrationService.register(registrationData);
        } catch (
                ConstraintViolationException cve) {
            log.warn("Business constraints were violated for {}", registrationData);
            for (ConstraintViolation<?> violation : cve.getConstraintViolations()) {
                log.warn("Violation: {}", violation);
                String field = null;
                for (Path.Node node : violation.getPropertyPath()) {
                    field = node.getName();
                }
//                Path field = violation.getPropertyPath();
                result.rejectValue(field,
                        violation.getConstraintDescriptor().getAnnotation().annotationType()
                                .getSimpleName() + ".registrationData." + field);
            }
            return "registration-form";
        }
        return "finish-registration";
    }

    @RequestMapping("/confirm-account")
    public String confirmRegistration(@RequestParam("token") String tokenUrl) {
        if (tokenService.makeUserActive(tokenUrl).equals(false)) {
            return "activation-failed";
        }
        return "activation-complete";
    }
}
