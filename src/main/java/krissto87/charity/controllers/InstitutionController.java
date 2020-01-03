package krissto87.charity.controllers;

import krissto87.charity.dtos.InstitutionDTO;
import krissto87.charity.services.InstitutionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/institutions") @Slf4j
public class InstitutionController {

    private final InstitutionService institutionService;

    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String displayAllInstitutionPage(Model model) {
        List<InstitutionDTO> institutions = institutionService.findAllInstitutions();
        model.addAttribute("institutions", institutions);
        return "admin/institution-all";
    }

    @GetMapping("/add")
    public String prepareNewInstitutionPage(Model model) {
        model.addAttribute("institution", new InstitutionDTO());
        return "admin/institution-form";
    }

    @PostMapping("/add")
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

    @GetMapping("/{id}/edit")
    public String prepareInstitutionEditPage(Model model, @PathVariable Long id) {
        InstitutionDTO institution = institutionService.findById(id);
        model.addAttribute("institution", institution);
        return "admin/edit-institution";
    }

    @PostMapping("/{id}/edit")
    public String processInstitutionUpdate(@Valid InstitutionDTO institutionDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/edit-institution";
        }
        institutionService.update(institutionDTO);
        return "redirect:/admin/institutions";
    }

    @GetMapping("/{id}/delete")
    public String prepareEditInstitutionPage(Model model, @PathVariable Long id) {
        InstitutionDTO institution = institutionService.findById(id);
        model.addAttribute("institution", institution);
        return "admin/delete-institution";
    }

    @PostMapping("/{id}/delete")
    public String processDeleteInstitution(@PathVariable Long id) {
        institutionService.deleteInstitutionById(id);
        return "redirect:/admin/institutions";
    }
}
