package com.dh.moneymanager.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/status","/health"})
public class HomeController {
    @GetMapping("/checkHealth")
    public String healthCheck(){
        return "Application is running";
    }
}
