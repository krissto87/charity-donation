package krissto87.charity.controllers;

import krissto87.charity.dtos.UserDTO;
import krissto87.charity.services.UserService;
import krissto87.charity.utils.SecurityUtils;
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
        String username = SecurityUtils.getUsername();
        UserDTO user = userService.findUserByName(username);
        model.addAttribute("user", user);
        return "user/edit-user-profile";
    }

    @PostMapping("/profile")
    public String processEditUserData(@Valid UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit-user-profile";
        }
        if (user != null) {
            userService.updateUser(user);
        }
        return "redirect:/login";
    }

    @GetMapping("/settings")
    public String userSettingsPage() {
        return "user/user-settings";
    }

    @GetMapping("settings/password-change")
    public String prepareUserPasswordChange(Model model){
        model.addAttribute("user", new UserDTO());
        return "user/password-change";
    }

    @PostMapping("settings/password-change")
    public String processPasswordChange(@ModelAttribute("user") @Valid UserDTO user,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit-user-profile";
        }
        if (user != null) {
            String password = user.getPassword();
            String username = SecurityUtils.getUsername();
            userService.changeUserPassword(username, password);
        }
        return "redirect:/user";
    }
}
