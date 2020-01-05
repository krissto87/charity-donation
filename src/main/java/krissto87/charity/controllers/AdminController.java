package krissto87.charity.controllers;

import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.dtos.EditAdminDTO;
import krissto87.charity.services.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins-all")
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
        adminService.save(admin);
        return "redirect:/admin/admins-all";
    }

    @GetMapping("/{id}/edit")
    public String prepareAdminEditPage(Model model, @PathVariable Long id) {
        EditAdminDTO admin = adminService.findUserById(id);
        model.addAttribute("admin", admin);
        return "admin/edit-admin";
    }

    @PostMapping("/{id}/edit")
    public String processAdminUpdate(@Valid EditAdminDTO admin, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/edit-admin";
        }
        adminService.update(admin);
        return "redirect:/admin/admins-all";
    }

    @GetMapping("/{id}/delete")
    public String prepareEditAdminPage(Model model, @PathVariable Long id) {
        EditAdminDTO admin = adminService.findUserById(id);
        model.addAttribute("admin", admin);
        return "admin/delete-admin";
    }

    @PostMapping("/{id}/delete")
    public String processDeleteAdmin(@PathVariable Long id) {
        adminService.deleteUserById(id);
        return "redirect:/admin/admins-all";
    }
}
