package krissto87.charity.controllers;

import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.dtos.EditAdminDTO;
import krissto87.charity.dtos.EditUserDTO;
import krissto87.charity.services.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins-all")
    public String displayAllAdmins(Model model) {
        model.addAttribute("admins", adminService.findAllAdmins());
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
        adminService.save(admin);
        return "redirect:/admin/admins-all";
    }

    @GetMapping("/{id}/edit")
    public String prepareAdminEditPage(Model model, @PathVariable Long id) {
        model.addAttribute("admin", adminService.findAdminById(id));
        return "admin/edit-admin";
    }

    @PostMapping("/{id}/edit")
    public String processAdminUpdate(@ModelAttribute("admin") @Valid EditAdminDTO admin, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/edit-admin";
        }
        adminService.updateAdmin(admin);
        return "redirect:/admin/admins-all";
    }

    @GetMapping("/{id}/delete")
    public String prepareDeleteAdminPage(Model model, @PathVariable Long id) {
        model.addAttribute("admin", adminService.findAdminById(id));
        return "admin/delete-admin";
    }

    @PostMapping("/{id}/delete")
    public String processDeleteAdmin(@ModelAttribute("admin") @PathVariable Long id) {
        adminService.deleteAdminById(id);
        return "redirect:/admin/admins-all";
    }

    @GetMapping("/users-all")
    public String displayAllUsers(Model model) {
        model.addAttribute("users", adminService.findAllUsers());
        return "/admin/users-all";
    }

    @GetMapping("/users/{id}/edit")
    public String prepareUserEditPage(Model model, @PathVariable Long id) {
        model.addAttribute("user", adminService.findUserById(id));
        return "admin/edit-user";
    }

    @PostMapping("/users/{id}/edit")
    public String processUserUpdate(@ModelAttribute("user") @Valid EditUserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/edit-user";
        }
        adminService.updateUser(user);
        return "redirect:/admin/users-all";
    }

    @GetMapping("/users/{id}/delete")
    public String prepareDeleteUserPage(Model model, @PathVariable Long id) {
        model.addAttribute("user", adminService.findUserById(id));
        return "admin/delete-user";
    }

    @PostMapping("/users/{id}/delete")
    public String processDeleteUser(@ModelAttribute("user") @PathVariable Long id) {
        adminService.deleteUserById(id);
        return "redirect:/admin/users-all";
    }

    @GetMapping("/users/{id}/block")
    public String blockUserById(@PathVariable Long id) {
        adminService.blockUserById(id);
        return "redirect:/admin/users-all";
    }

    @GetMapping("/users/{id}/activate")
    public String activateUserById(@PathVariable Long id) {
        adminService.activateUserById(id);
        return "redirect:/admin/users-all";
    }
}
