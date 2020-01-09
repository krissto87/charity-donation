package krissto87.charity.controllers;

import krissto87.charity.dtos.CourierStatusDTO;
import krissto87.charity.services.DonationService;
import krissto87.charity.utils.GeneralUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import krissto87.charity.dtos.DonationDTO;
import krissto87.charity.services.CategoryService;
import krissto87.charity.services.InstitutionService;

import javax.validation.Valid;
import java.util.List;

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
        log.debug("DonationDTO data post begin: {}", donationDTO);
        if (result.hasErrors()) {
            return "user/donation-form";
        }
        donationService.saveDonation(donationDTO);
        log.info("New donation added!");
        return "redirect:/user/donation/confirmation";
    }

    @RequestMapping("/confirmation")
    public String processFormConfirmation() {
        return "/user/form-confirmation";
    }

    @GetMapping("/all")
    public String displayAllUserDonation(Model model) {
        String username = GeneralUtils.getUsername();
        List<DonationDTO> donations = donationService.findAllByUser(username);
        model.addAttribute("donations", donations);
        return "user/donation-all";
    }

    @GetMapping("/pick-up-confirm/{id}")
    public String prepareConfirmCourierVisit(Model model, @PathVariable Long id) {
        CourierStatusDTO status = donationService.findToSetStatusById(id);
        model.addAttribute("status", status);
        return "user/pick-up-confirmation";
    }

    @PostMapping("/pick-up-confirm/{id}")
    public String processConfirmCourierVisit(@PathVariable Long id, @Valid CourierStatusDTO statusDTO,
                                             BindingResult result) {
        if (result.hasErrors()) {
            return "user/donation-all";
        }
        donationService.confirmCourierVisit(statusDTO);
        return "redirect:/user/donation/all";
    }

    @GetMapping("/{id}/details")
    public String displayDonationDetails(Model model, @PathVariable Long id) {
        model.addAttribute("donation", donationService.findById(id));
        return "user/donation-details";
    }

    @GetMapping("{id}/pick-up-details")
    public String displayCourierDetails(Model model, @PathVariable Long id) {
        model.addAttribute("donation", donationService.findById(id));
        return "user/donation-courier";
    }
}
