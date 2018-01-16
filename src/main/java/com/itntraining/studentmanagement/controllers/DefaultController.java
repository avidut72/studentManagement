package com.itntraining.studentmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class DefaultController {

    @GetMapping({"/home", "/"})
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/department")
    public String getDepartmentPage() {
        return "department";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }
    @GetMapping("/student")
    public String getStudentPage() {
        return "student";
    }
    @GetMapping("/login")
    public String login(){
        return "/login";
    }
    @GetMapping("/403")
    public String error403(){
        return "/error/403";
    }
}
