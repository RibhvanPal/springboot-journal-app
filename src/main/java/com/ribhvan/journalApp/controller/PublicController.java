package com.ribhvan.journalApp.controller;

import com.ribhvan.journalApp.entity.User;
import com.ribhvan.journalApp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userservice;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "Ok";
    }

    @PostMapping("/create-user")
    public void createUser(@Valid @RequestBody User user){
        userservice.saveNewUser(user);
    }
}
