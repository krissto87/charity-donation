package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dtos.AddDonationDTO;
import pl.coderslab.charity.services.CategoryService;
import pl.coderslab.charity.services.DonationService;
import pl.coderslab.charity.services.InstitutionService;

import javax.validation.Valid;

@Controller
@RequestMapping("/donation")
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
        model.addAttribute("donation", new AddDonationDTO());
        return "/user/donation-form";
    }

    @PostMapping
    public String processDonationForm(@ModelAttribute("donation") @Valid AddDonationDTO donationDTO,
                                      BindingResult result) {
//        if (result.hasErrors()) {
//            return "user/donation-form";
//        }
        donationService.saveDonation(donationDTO);
        return "redirect:/donation/form-confirmation";
    }
}
