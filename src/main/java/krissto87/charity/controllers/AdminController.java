package krissto87.charity.controllers;

import krissto87.charity.dtos.AdminDTO;
import krissto87.charity.services.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/admins-all")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String displayAllAdmins(Model model) {
        List<AdminDTO> admins = adminService.findAll();
        model.addAttribute("admins", admins);
        return "/admin/admins-all";
    }
}
