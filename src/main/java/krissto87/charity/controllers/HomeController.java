package krissto87.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import krissto87.charity.services.DonationService;
import krissto87.charity.services.InstitutionService;



@Controller
@RequestMapping("/")
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.findAllInstitutions());
        model.addAttribute("countOfInstitutions", donationService.countOfInstitutionsWithDonations());
        model.addAttribute("countOfBags", donationService.sumBagsFromAllDonations());
        return "index";
    }

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin/admin-homepage";
    }

    @GetMapping("/user")
    public String userDashboard() {
        return "/user/user-homepage";
    }
}
