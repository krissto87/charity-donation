package krissto87.charity.controllers;

import krissto87.charity.dtos.RemindPasswordDTO;
import krissto87.charity.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class RemindPasswordController {

    private final UserService userService;

    public RemindPasswordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/remind-password")
    public String prepareRemindPasswordPage(Model model) {
        model.addAttribute("remindPassword", new RemindPasswordDTO());
        return "remind-password";
    }

    @PostMapping("/remind-password")
    public String sendEmailToResetPassword(@ModelAttribute("remindPassword") @Valid RemindPasswordDTO
                                                       remindPasswordDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "remind-password";
        }
        else {
            if (userService.emailValidity(remindPasswordDTO.getEmail()).equals(false)) {
                return "invalid-email";
            }
            return "remind-sending-complete";
        }
    }
}