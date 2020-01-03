package krissto87.charity.controllers;

import krissto87.charity.dtos.InstitutionDTO;
import krissto87.charity.services.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/institutions")
    public String displayAllInstitutionPage(Model model) {
        List<InstitutionDTO> institutions = adminService.findAll();
        model.addAttribute("institutions", institutions);
        return "admin/institution-all";
    }
}
