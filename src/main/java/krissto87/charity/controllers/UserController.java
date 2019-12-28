package krissto87.charity.controllers;

import krissto87.charity.dtos.UserDTO;
import krissto87.charity.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String prepareEditUserDataPage(Model model, Principal principal) {
        String username = principal.getName();
        UserDTO user = userService.findUserByName(username);
        model.addAttribute("user", user);
        return "user/edit-user-profile";
    }

    @PostMapping("/profile")
    public String processEditUserData(@Valid UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit-user-profile";
        }
        if (userDTO != null) {
            userService.updateUser(userDTO);
        }
        return "redirect:/user";
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
    public String processPasswordChange(@ModelAttribute("user") @Valid UserDTO userDTO,
                                        BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            return "user/edit-user-profile";
        }
        if (userDTO != null) {
            String password = userDTO.getPassword();
            String username = principal.getName();
            userService.changeUserPassword(username, password);
        }
        return "redirect:/user";
    }
}
