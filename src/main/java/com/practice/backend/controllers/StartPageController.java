package com.practice.backend.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartPageController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message","Some info");
        return "index";
    }
}
