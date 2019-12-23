package krissto87.charity.controllers;

import krissto87.charity.services.DonationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import krissto87.charity.dtos.DonationDTO;
import krissto87.charity.services.CategoryService;
import krissto87.charity.services.InstitutionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/donation") @Slf4j
public class DonationController {

    private final CategoryService categoryService;
    private final DonationService donationService;
    private final InstitutionService institutionService;

    public DonationController(CategoryService categoryService, DonationService donationService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.donationService = donationService;
        this.institutionService = institutionService;
    }

    @GetMapping
    public String prepareDonationForm(Model model) {
        model.addAttribute("categories", categoryService.findAllCategory());
        model.addAttribute("institutions", institutionService.findAllInstitutions());
        model.addAttribute("donation", new DonationDTO());
        return "/user/donation-form";
    }

    @PostMapping
    public String processDonationForm(@ModelAttribute("donation")
                                          @Valid DonationDTO donationDTO, BindingResult result) {
        log.debug("Donation data: {}", donationDTO);
        if (result.hasErrors()) {
            return "user/donation-form";
        }
        donationService.saveDonation(donationDTO);
        log.info("Dodano kolejny dar!");
        return "redirect:/user/donation/form-confirmation";
    }
}
