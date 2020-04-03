package krissto87.charity.controllers;

import krissto87.charity.dtos.ChangePasswordDto;
import krissto87.charity.dtos.RemindPasswordDto;
import krissto87.charity.services.UserService;
import krissto87.charity.services.VerificationTokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
public class RemindPasswordController {

    private final UserService userService;
    private final VerificationTokenService tokenService;

    public RemindPasswordController(UserService userService, VerificationTokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @GetMapping("/remind-password")
    public String prepareRemindPasswordPage(Model model) {
        model.addAttribute("remindPassword", new RemindPasswordDto());
        return "remind-password";
    }

    @PostMapping("/remind-password")
    public String sendEmailToResetPassword(@ModelAttribute("remindPassword") @Valid RemindPasswordDto
                                                       remindPasswordDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "remind-password";
        }
        else {
            if (userService.sendEmailToResetPassword(remindPasswordDTO.getEmail()).equals(false)) {
                return "invalid-email";
            }
            return "remind-sending-complete";
        }
    }

    @GetMapping("/reset-password")
    public String prepareChangePasswordForm (Model model, @RequestParam("token") String tokenUrl) {
        if (tokenService.isTokenValidToRemindPassword(tokenUrl).equals(false)) {
            return "reset-password-failed";
        }
        model.addAttribute("changePassword", new ChangePasswordDto());
        return "reset-password-form";
    }

    @PostMapping("/reset-password")
    public String processChangePassword (@ModelAttribute("changePassword") @Valid ChangePasswordDto changePassword,
                                         BindingResult result, @RequestParam("token") String tokenUrl) {
        if (result.hasErrors()) {
            return "reset-password-form";
        }
        userService.changeUserPasswordAfterRemind(changePassword, tokenUrl);
        return "reset-password-complete";
    }

}