package krissto87.charity.controllers;

import krissto87.charity.dtos.ChangePasswordDto;
import krissto87.charity.dtos.UserProfileDto;
import krissto87.charity.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String prepareEditUserDataPage(Model model) {
        model.addAttribute("profile", userService.findUser());
        return "user/edit-user-profile";
    }

    @PostMapping("/profile")
    public String processEditUserData(@ModelAttribute("profile") @Valid UserProfileDto profile,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit-user-profile";
        }
        userService.updateUser(profile);
        return "redirect:/login";
    }

    @GetMapping("/settings")
    public String userSettingsPage() {
        return "user/user-settings";
    }

    @GetMapping("settings/password-change")
    public String prepareUserPasswordChange(Model model){
        model.addAttribute("user", new ChangePasswordDto());
        return "user/password-change";
    }

    @PostMapping("settings/password-change")
    public String processPasswordChange(@ModelAttribute("user") @Valid ChangePasswordDto changePassword,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit-user-profile";
        }
        userService.changeUserPassword(changePassword);
        return "redirect:/user";
    }
}
