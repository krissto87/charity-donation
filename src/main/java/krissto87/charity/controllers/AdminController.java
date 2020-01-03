package krissto87.charity.controllers;

import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.services.AdminService;
import krissto87.charity.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/admins-all")
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;

    public AdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    @GetMapping
    public String displayAllAdmins(Model model) {
        List<AdminDTO> admins = adminService.findAll();
        model.addAttribute("admins", admins);
        return "/admin/admins-all";
    }

    @GetMapping("/add")
    public String prepareNewAdminForm(Model model) {
        model.addAttribute("admin", new AdminDTO());
        return "/admin/admin-form";
    }

    @PostMapping("/add")
    public String processCreateNewAdmin(@ModelAttribute("admin")
                                            @Valid AdminDTO admin, BindingResult result){
        if (result.hasErrors()) {
            return "admin/admin-form";
        }
        userService.save(admin);
        return "redirect:/admin/admins-all";
    }
}
