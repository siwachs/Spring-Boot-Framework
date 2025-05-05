package com.company.restApis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.service.UserService;

@RestController
public class Api {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String userLogin() {
        userService.login();
        return "User loggedin";
    }
}
