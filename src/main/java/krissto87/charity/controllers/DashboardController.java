package krissto87.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DashboardController {

    @GetMapping("/admin")
    public String adminDashboard() {
        return "admin/admin-homepage";
    }

    @GetMapping("/user")
    public String userDashboard() {
        return "/user/user-homepage";
    }

}