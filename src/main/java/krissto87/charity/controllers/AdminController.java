package krissto87.charity.controllers;

import krissto87.charity.dtos.InstitutionDTO;
import krissto87.charity.services.InstitutionService;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/admin") @Slf4j
public class AdminController {

    private final InstitutionService institutionService;

    public AdminController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/institutions")
    public String displayAllInstitutionPage(Model model) {
        List<InstitutionDTO> institutions = institutionService.findAllInstitutions();
        model.addAttribute("institutions", institutions);
        return "admin/institution-all";
    }

    @GetMapping("/institutions/add")
    public String prepareNewInstitutionPage(Model model) {
        model.addAttribute("institution", new InstitutionDTO());
        return "admin/institution-form";
    }

    @PostMapping("/institutions/add")
    public String processCreateNewInstitution(@ModelAttribute("institution")
                                                  @Valid InstitutionDTO institution, BindingResult result) {
        log.debug("InstitutionDTO data: {}", institution);
        if (result.hasErrors()) {
            return "admin/institution-form";
        }
        institutionService.save(institution);
        log.info("New institution added!");
        return "redirect:/admin/institutions";
    }
}
